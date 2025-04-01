package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;


import com.pm.authservice.util.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public Optional<String> authenticateUser(LoginRequestDTO loginRequestDTO) {
        // Simulate authentication logic
        Optional<String> token = userService.findByEmail(loginRequestDTO.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
                .map(u -> jwtUtils.generateToken(u.getEmail(), u.getRole()));

        return token;
    }

    public boolean validateToken(String token) {
        try {
            jwtUtils.validateToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
