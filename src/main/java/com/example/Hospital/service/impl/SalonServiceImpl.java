package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Salon;
import com.example.Hospital.repository.SalonRepository;
import com.example.Hospital.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    private SalonRepository salonRepository;

    @Autowired
    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }
    @Override
    public List<Salon> getAllSalon() {
        return salonRepository.findAll();
    }


    @Override
    public Salon getSalonById(Long id) {
        Optional<Salon> salonOptional = salonRepository.findById(id);
        if (salonOptional.isPresent()) {
            return salonOptional.get();
        }
        return salonOptional.orElseThrow(()-> new RuntimeException("No such Salon"));
    }

    @Override
    public Salon saveSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    @Override
    public void deleteSalon(Long id) {
        Optional<Salon> salonOptional = salonRepository.findById(id);
        if(!salonOptional.isPresent()) {
            throw new RuntimeException("No such Salon");
        }
        salonRepository.deleteById(id);
    }

    @Override
    public void updateSalon(Long id, Salon salon) {
        Optional<Salon> salonOptional = salonRepository.findById(id);
        if(!salonOptional.isPresent()) {
            throw new RuntimeException("No such Salon");
        }else {
            Salon salon1 = salonOptional.get();
            salon1.setNumarSalon(salon.getNumarSalon());
            salon1.setCapacitate(salon.getCapacitate());
            salonRepository.save(salon1);
        }
    }
}
