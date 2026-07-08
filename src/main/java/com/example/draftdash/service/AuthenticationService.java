package com.example.draftdash.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.draftdash.entity.authenticationEntity;
import com.example.draftdash.repository.authenticationRepository;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final authenticationRepository repo;

    public AuthenticationService(PasswordEncoder passwordEncoder,
                                 authenticationRepository repo) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }

    public authenticationEntity register(authenticationEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(authenticationEntity.Role.STUDENT);
        }

        return repo.save(user);
    }

   
    public boolean verifyPassword(String email, String password) {

        authenticationEntity user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return passwordEncoder.matches(password, user.getPassword());
    }
}