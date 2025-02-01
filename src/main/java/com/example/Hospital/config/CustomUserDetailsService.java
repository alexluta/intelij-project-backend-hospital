package com.example.Hospital.config;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Verificăm utilizatorul după username
        if ("adi@yahoo.com".equals(username)) {
            return new User(
                    username, // Username
                    "$2a$10$5xtYUzeNAHbPV6bD99HMjOwHExVM.9WaT35Q1fnZvf2YPcRzryRpu", // Parola criptată
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")) // Roluri
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
