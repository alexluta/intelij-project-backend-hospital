package com.example.Hospital.repository;

import com.example.Hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
   // Optional<User> findByEmail(String email); // Modificat să returneze Optional<User
}
