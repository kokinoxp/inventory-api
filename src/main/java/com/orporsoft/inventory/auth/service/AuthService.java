package com.orporsoft.inventory.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.orporsoft.inventory.auth.dto.LoginRequest;
import com.orporsoft.inventory.auth.dto.LoginResponse;
import com.orporsoft.inventory.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
            )
        );
        
        String token = jwtService.generateToken(request.getUsername());

        return LoginResponse.builder()
                .token(token)
                .type("Bearer")
                .expiresIn(3600000L)
                .build();
    }

}
