package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.config.jwt.JwtService;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.db.repository.RoleRepository;
import com.example.gadgetariumb7.db.repository.UserRepository;
import com.example.gadgetariumb7.db.service.AuthenticationService;
import com.example.gadgetariumb7.dto.request.AuthenticationRequest;
import com.example.gadgetariumb7.dto.request.RegisterRequest;
import com.example.gadgetariumb7.dto.response.AuthenticationResponse;
import com.example.gadgetariumb7.exceptions.BadRequestException;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;


    @PostConstruct
    void init() {
        try {
            GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ClassPathResource("gadgetarium.json").getInputStream());
            FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                    .setCredentials(googleCredentials)
                    .build();
            log.info("successfully works the init method");
            FirebaseApp firebaseApp = FirebaseApp.initializeApp(firebaseOptions);
        } catch (IOException e) {
            log.error("IOException");
        }
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (repository.existsByEmail(request.getEmail()))
            throw new BadRequestException(String.format("User with email %s already exist", request.getEmail()));

        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleRepository.getById(2L))
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        log.info("successfully works the register method");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .roleName(user.getRole().getRoleName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        log.info("successfully works the authenticate method");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .roleName(user.getRole().getRoleName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponse authWithGoogle(String tokenId) throws FirebaseAuthException {
        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(tokenId);
        if (!repository.existsByEmail(firebaseToken.getEmail())) {
            User newUser = new User();
            String[] name = firebaseToken.getName().split(" ");
            newUser.setFirstName(name[0]);
            newUser.setLastName(name[1]);
            newUser.setEmail(firebaseToken.getEmail());
            newUser.setPassword(firebaseToken.getEmail());
            newUser.setRole(roleRepository.getById(2L));

            repository.save(newUser);
        }
        User user = repository.findByEmail(firebaseToken.getEmail()).orElseThrow(() -> {
            log.error(String.format("Пользователь с таким электронным адресом %s не найден!", firebaseToken.getEmail()));
            throw new NotFoundException(String.format("Пользователь с таким электронным адресом %s не найден!", firebaseToken.getEmail()));
        });
        String token = jwtService.generateToken(user);
        log.info("successfully works the authorization with google method");
        return new AuthenticationResponse(token, user.getRole().getRoleName(), user.getEmail());
    }

    @Override
    public AuthenticationResponse getToken(User user) {
        String jwtToken = jwtService.generateToken(user);
        log.info("successfully works the get token method");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .roleName(user.getRole().getRoleName())
                .email(user.getEmail())
                .build();
    }

}