package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Sectie;
import com.example.Hospital.repository.SectieRepository;
import com.example.Hospital.service.SectieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectieServiceImpl implements SectieService {

    private SectieRepository sectieRepository;

    @Autowired
    public SectieServiceImpl(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }
    @Override
    public List<Sectie> getAllSectie() {
        return sectieRepository.findAll();
    }


    @Override
    public Sectie getSectieById(Long id) {
        Optional<Sectie> sectieOptional = sectieRepository.findById(id);
        if (sectieOptional.isPresent()) {
            return sectieOptional.get();
        }
        return sectieOptional.orElseThrow(()-> new RuntimeException("No such Sectie"));
    }

    @Override
    public Sectie saveSectie(Sectie sectie) {
        return sectieRepository.save(sectie);
    }

    @Override
    public void deleteSectie(Long id) {
        Optional<Sectie> sectieOptional = sectieRepository.findById(id);
        if(!sectieOptional.isPresent()) {
            throw new RuntimeException("No such Sectie");
        }
        sectieRepository.deleteById(id);
    }

    @Override
    public void updateSectie(Long id, Sectie sectie) {
        Optional<Sectie> sectieOptional = sectieRepository.findById(id);
        if(!sectieOptional.isPresent()) {
            throw new RuntimeException("No such Sectie");
        }else {
            Sectie sectie1 = sectieOptional.get();
            sectie1.setDenumire(sectie.getDenumire());
            sectieRepository.save(sectie1);
        }
    }

}
