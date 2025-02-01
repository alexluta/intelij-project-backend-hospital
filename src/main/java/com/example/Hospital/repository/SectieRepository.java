package com.example.Hospital.repository;

import com.example.Hospital.entity.Sectie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectieRepository extends JpaRepository<Sectie, Long> {
}
