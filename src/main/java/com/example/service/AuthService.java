package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String password) {

        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(username);

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(password));

        // Default role
        user.setRole("USER");

        return userRepository.save(user);
    }
}