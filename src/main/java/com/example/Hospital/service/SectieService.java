package com.example.Hospital.service;

import com.example.Hospital.entity.Sectie;

import java.util.List;

public interface SectieService {
    List<Sectie> getAllSectie();
    Sectie getSectieById(Long id);
    Sectie saveSectie(Sectie sectie);
    void deleteSectie(Long id);
    void updateSectie(Long id, Sectie sectie);
}
