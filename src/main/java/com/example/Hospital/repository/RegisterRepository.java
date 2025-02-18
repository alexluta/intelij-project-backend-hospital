package com.example.Hospital.repository;

import com.example.Hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository  extends JpaRepository<User, Long> {

}


