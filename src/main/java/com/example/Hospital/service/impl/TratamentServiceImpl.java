package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Medic;
import com.example.Hospital.entity.Tratament;
import com.example.Hospital.repository.MedicRepository;
import com.example.Hospital.repository.TratamentRepository;
import com.example.Hospital.service.TratamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamentServiceImpl implements TratamentService {

    private TratamentRepository tratamentRepository;

    @Autowired
    public TratamentServiceImpl(TratamentRepository tratamentRepository) {
        this.tratamentRepository = tratamentRepository;
    }

    @Override
    public List<Tratament> getAllTratament() {
        return tratamentRepository.findAll();
    }

    @Override
    public Tratament getTratamentById(Long id) {
        Optional<Tratament> tratamentOptional = tratamentRepository.findById(id);
        if (tratamentOptional.isPresent()) {
            return tratamentOptional.get();
        }
        return tratamentOptional.orElseThrow(()-> new RuntimeException("No such Tratament"));
    }

    @Override
    public Tratament saveTratament(Tratament tratament) {
        return tratamentRepository.save(tratament);
    }

    @Override
    public void deleteTratament(Long id) {
        Optional<Tratament> tratamentOptional = tratamentRepository.findById(id);
        if(!tratamentOptional.isPresent()) {
            throw new RuntimeException("No such Tratament");
        }
        tratamentRepository.deleteById(id);
    }

    @Override
    public void updateTratament(Long id, Tratament tratament) {
        Optional<Tratament> tratamentOptional = tratamentRepository.findById(id);
        if(!tratamentOptional.isPresent()) {
            throw new RuntimeException("No such Tratament");
        }else {
            Tratament tratament1 = tratamentOptional.get();
            tratament1.setDenumire(tratament.getDenumire());
            tratament1.setDescriere(tratament.getDescriere());
            tratament1.setDurata(tratament.getDurata());
            tratamentRepository.save(tratament1);
        }

    }
}
