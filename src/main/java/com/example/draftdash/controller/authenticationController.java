package com.example.draftdash.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.draftdash.entity.authenticationEntity;
import com.example.draftdash.service.AuthenticationService;
import com.example.draftdash.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class authenticationController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    public authenticationController(JwtService jwtService,
                                    AuthenticationManager authenticationManager,
                                    AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
    }

   @PostMapping("/register")
public ResponseEntity<?> register(@Valid @RequestBody authenticationEntity user) {
    try {
        authenticationEntity users = authenticationService.register(user);
        return ResponseEntity.ok(users);

    } catch (Exception e) {

        Map<String, String> errStmt = new HashMap<>();

        if (e.getMessage() != null &&
            e.getMessage().toLowerCase().contains("duplicate")) {

            errStmt.put("message", "Email id already registered");

        } else {

            errStmt.put("message", "Registration failed! " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errStmt);
    }
}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody authenticationEntity user) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );

            String token = jwtService.generateToken(user.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login Successful");
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

    e.printStackTrace();

    Map<String, Object> response = new HashMap<>();
    response.put("error", e.getClass().getSimpleName());
    response.put("message", e.getMessage());

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
}
    }
}