package com.example.Hospital.util;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT version();", String.class);
            System.out.println("Connected to PostgreSQL: " + result);
        } catch (Exception e) {
            System.err.println("Error connecting to PostgreSQL: " + e.getMessage());
        }
    }
}
