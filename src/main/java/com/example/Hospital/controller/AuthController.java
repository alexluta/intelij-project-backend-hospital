package com.example.Hospital.controller;

import com.example.Hospital.LoginResponse;
import com.example.Hospital.config.JwtService;
import com.example.Hospital.config.LoginRequest;
import com.example.Hospital.config.RegisterRequest;
import com.example.Hospital.entity.User;
import com.example.Hospital.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtUtil;



    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            userServiceImpl.registerNewUser(registerRequest.getEmail(), registerRequest.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error registering user: " + e.getMessage());
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//        String email = loginRequest.getEmail();
//        User user = userServiceImpl.findByEmail(loginRequest.getEmail());
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");
//        }
//
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            String token = jwtUtil.generateToken(user.getEmail(), List.of("ROLE_USER"));
//            return ResponseEntity.ok("tonek " + token);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
//        }
//    }
@PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
    String email = loginRequest.getEmail();
    User user = userServiceImpl.findByEmail(email);

    if (user == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid email\"}");
    }

    if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        String token = jwtUtil.generateToken(user.getEmail(), List.of("ROLE_USER"));
        return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid password\"}");
    }
}


}
