package com.example.Hospital.service.impl;

import com.example.Hospital.entity.User;
import com.example.Hospital.service.RegisterService;
import com.example.Hospital.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegisterServiceImpl(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String email, String password) {
        // Verifică dacă utilizatorul există deja
        if (userService.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already in use");
        }

        // Criptează parola
        String hashedPassword = passwordEncoder.encode(password);

        // Creează și salvează utilizatorul
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);

        return userService.saveUser(newUser);
    }
}
