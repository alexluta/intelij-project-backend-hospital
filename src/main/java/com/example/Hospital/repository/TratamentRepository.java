package com.example.Hospital.repository;

import com.example.Hospital.entity.Tratament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentRepository extends JpaRepository <Tratament, Long>{
}
