package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Medic;
import com.example.Hospital.repository.MedicRepository;
import com.example.Hospital.service.MedicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicServiceImpl implements MedicService {

    private MedicRepository medicRepository;

    @Autowired
    public MedicServiceImpl(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public List<Medic> getAllMedic() {
        return medicRepository.findAll();
    }

    @Override
    public Medic getMedicById(Long id) {
        Optional<Medic> medicOptional = medicRepository.findById(id);
        if (medicOptional.isPresent()) {
            return medicOptional.get();
        }
        return medicOptional.orElseThrow(()-> new RuntimeException("No such Medic"));
    }

    @Override
    public Medic saveMedic(Medic medic) {
        return medicRepository.save(medic);
    }

    @Override
    public void deleteMedic(Long id) {
        Optional<Medic> medicOptional = medicRepository.findById(id);
        if(!medicOptional.isPresent()) {
            throw new RuntimeException("No such Medic");
        }
        medicRepository.deleteById(id);
    }

    @Override
    public void updateMedic(Long id, Medic medic) {
        Optional<Medic> medicOptional = medicRepository.findById(id);
        if(!medicOptional.isPresent()) {
            throw new RuntimeException("No such Medic");
        }else {
            Medic medic1 = medicOptional.get();
            medic1.setNume(medic.getNume());
            medic1.setPrenume(medic.getPrenume());
            medicRepository.save(medic1);
        }

    }
}