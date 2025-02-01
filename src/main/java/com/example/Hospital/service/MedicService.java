package com.example.Hospital.service;

import com.example.Hospital.entity.Medic;

import java.util.List;

public interface MedicService {
    List<Medic> getAllMedic();
    Medic getMedicById(Long id);
    Medic saveMedic(Medic medic);
    void deleteMedic(Long id);
    void updateMedic(Long id, Medic medic);
}
