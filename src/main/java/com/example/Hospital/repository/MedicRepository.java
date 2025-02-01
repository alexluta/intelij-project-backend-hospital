package com.example.Hospital.repository;

import com.example.Hospital.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
}
