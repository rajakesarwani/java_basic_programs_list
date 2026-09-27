package com.example.controller;

import com.example.dto.RegisterRequest;
import com.example.entity.User;
import com.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest request) {

        User user = authService.register(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok(user);
    }
}