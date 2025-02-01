package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Pacient;
import com.example.Hospital.repository.PacientRepository;
import com.example.Hospital.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientServiceImpl implements PacientService {

    private PacientRepository pacientRepository;

    @Autowired
    public PacientServiceImpl(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    @Override
    public List<Pacient> getAllPacient() {
        return pacientRepository.findAll();
    }

    @Override
    public Pacient getPacientById(Long id) {
        Optional<Pacient> pacientOptional = pacientRepository.findById(id);
        if (pacientOptional.isPresent()) {
            return pacientOptional.get();
        }
        return pacientOptional.orElseThrow(()-> new RuntimeException("No such Pacient"));
    }

    @Override
    public Pacient savePacient(Pacient pacient) {
        return pacientRepository.save(pacient);
    }

    @Override
    public void deletePacient(Long id) {
        Optional<Pacient> pacientOptional = pacientRepository.findById(id);
        if(!pacientOptional.isPresent()) {
            throw new RuntimeException("No such Pacient");
        }
        pacientRepository.deleteById(id);
    }

    @Override
    public void updatePacient(Long id, Pacient pacient) {
        Optional<Pacient> pacientOptional = pacientRepository.findById(id);
        if(!pacientOptional.isPresent()) {
            throw new RuntimeException("No such Pacient");
        }else {
            Pacient pacient1 = pacientOptional.get();
            pacient1.setNume(pacient.getNume());
            pacient1.setPrenume(pacient.getPrenume());
            pacientRepository.save(pacient1);
        }
    }
}
