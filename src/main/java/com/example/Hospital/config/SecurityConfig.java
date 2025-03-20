
package com.example.Hospital.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtService jwtUtil;

    public SecurityConfig(JwtService jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtUtil);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/auth/register").permitAll() // Permite înregistrarea utilizatorilor
                .requestMatchers("/deleteMedic/**").permitAll()
                .requestMatchers("/selectMedic/**").permitAll()
                .requestMatchers("/raportMedici").permitAll()
                .requestMatchers("/raportAsistente").permitAll()
                .requestMatchers("/deleteAsistente/**").permitAll()
                .requestMatchers("/selectAsistente/**").permitAll()
                .requestMatchers("/selectSectie").permitAll()
                .requestMatchers("/raportPacienti").permitAll()
                .requestMatchers("/raportSaloane").permitAll()
                .anyRequest().authenticated() // Permite doar cererile autentificate
                .and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Îți poți alege orice alt encoder, dar BCrypt este recomandat.
    }
}