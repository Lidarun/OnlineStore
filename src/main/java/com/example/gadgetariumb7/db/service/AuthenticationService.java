package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.dto.request.AuthenticationRequest;
import com.example.gadgetariumb7.dto.request.RegisterRequest;
import com.example.gadgetariumb7.dto.response.AuthenticationResponse;
import com.google.firebase.auth.FirebaseAuthException;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse authWithGoogle(String tokenId) throws FirebaseAuthException;

    AuthenticationResponse getToken(User user);

}