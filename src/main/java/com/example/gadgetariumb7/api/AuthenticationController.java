package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.AuthenticationService;
import com.example.gadgetariumb7.dto.request.AuthenticationRequest;
import com.example.gadgetariumb7.dto.request.RegisterRequest;
import com.example.gadgetariumb7.dto.response.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Auth API")
public class AuthenticationController {

    private final AuthenticationService service;

    @Operation(summary = "Sign up", description = "Any user can register")
    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody @Valid RegisterRequest request) {
        return service.register(request);
    }

    @Operation(summary = "Sign in", description = "Any user can login")
    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }

    @Operation(summary = "Suthorization with google", description = "You can register by google account")
    @PostMapping("/auth-google")
    public AuthenticationResponse authWithGoogle(String tokenId) throws FirebaseAuthException {
        return service.authWithGoogle(tokenId);
    }

}
