package com.example.Hospital.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey = "mySecretKey"; // Folosește o cheie secretă mai complexă într-o aplicație reală

    // Metodă pentru generarea unui token JWT
    public String generateToken(String email, List<String> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Tokenul expiră după 1 oră
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Metodă pentru validarea token-ului
    public boolean validateToken(String token, String email) {
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }

    // Verifică dacă tokenul a expirat
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extrage data de expirare a token-ului
    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
