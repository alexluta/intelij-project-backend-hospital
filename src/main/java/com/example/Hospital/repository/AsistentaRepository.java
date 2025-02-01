package com.example.Hospital.repository;

import com.example.Hospital.entity.Asistenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistentaRepository extends JpaRepository<Asistenta,Long> {
}
