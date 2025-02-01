package com.example.Hospital.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String username;
    private final String credentials; // Va fi token-ul JWT

    // Constructor
    public JwtAuthenticationToken(String username, String credentials) {
        super(Collections.emptyList()); // La început, nu are autorități
        this.username = username;
        this.credentials = credentials;  // Token-ul JWT
        setAuthenticated(true); // Setați ca autentificat
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // Returnează o listă de autorități de tipul corect
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Object getCredentials() {
        return this.credentials; // Returnează credențialele (token-ul JWT)
    }

    @Override
    public Object getPrincipal() {
        return this.username; // Returnează numele utilizatorului
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) {
        super.setAuthenticated(isAuthenticated); // Setează starea de autentificare
    }

    @Override
    public String getName() {
        return this.username; // Returnează numele utilizatorului
    }
}
