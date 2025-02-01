package com.example.Hospital.service;

import com.example.Hospital.entity.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> getAllSalon();
    Salon getSalonById(Long id);
    Salon saveSalon(Salon salon);
    void deleteSalon(Long id);
    void updateSalon(Long id, Salon salon);
}
