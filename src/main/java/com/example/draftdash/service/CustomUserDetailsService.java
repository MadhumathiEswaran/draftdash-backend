package com.example.draftdash.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.draftdash.entity.authenticationEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.authenticationRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final authenticationRepository userRepo;

    public CustomUserDetailsService(authenticationRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        authenticationEntity user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFound("User Not Found: " + email));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}