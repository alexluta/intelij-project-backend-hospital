package com.example.Hospital.config;


import io.jsonwebtoken.Jwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {


    private final JwtService jwtUtil;


    public JwtAuthenticationFilter(JwtService jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String token = extractJwtToken(request);

        if (token != null) {
            String username = jwtUtil.extractEmail(token);


            if (jwtUtil.validateToken(token, username))  {

                JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(username, token);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        chain.doFilter(request, response);
    }


    private String extractJwtToken(HttpServletRequest request) {
        // Logica pentru extragerea token-ului JWT din request
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
