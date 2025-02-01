package com.example.Hospital.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordGeneratorRunner   implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String plainPassword = "parola_ta";
        String encodedPassword = new BCryptPasswordEncoder().encode(plainPassword);
        System.out.println("Parola criptată: " + encodedPassword);
    }
}
