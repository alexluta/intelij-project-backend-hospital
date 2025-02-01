package com.example.Hospital.service;

import com.example.Hospital.entity.Pacient;

import java.util.List;

public interface PacientService {
    List<Pacient> getAllPacient();
    Pacient getPacientById(Long id);
    Pacient savePacient(Pacient pacient);
    void deletePacient(Long id);
    void updatePacient(Long id, Pacient pacient);
}
