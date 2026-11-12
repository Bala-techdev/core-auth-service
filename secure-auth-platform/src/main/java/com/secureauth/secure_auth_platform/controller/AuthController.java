package com.secureauth.secure_auth_platform.controller;

import com.secureauth.secure_auth_platform.dto.ApiResponse;
import com.secureauth.secure_auth_platform.dto.JwtAuthenticationResponse;
import com.secureauth.secure_auth_platform.dto.LoginRequest;
import com.secureauth.secure_auth_platform.dto.RegisterRequest;
import com.secureauth.secure_auth_platform.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            authService.registerUser(registerRequest);
            return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, ex.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtAuthenticationResponse token = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(token);
    }
}