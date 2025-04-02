package com.example.Hospital.config;


import com.example.Hospital.repository.UserRepository;
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
        if ("alex@yahoo.com".equals(username)) {
            return new User(
                    username, // Username
                    "$2a$10$wUHgO7J4YgP0gZ7OaZZIh..4sCwD0nJ3fFIS1qOInM1cMtb/xvC9K", // Parola criptată
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")) // Roluri
            );
        }
        throw new UsernameNotFoundException("User not found");
    }

}
