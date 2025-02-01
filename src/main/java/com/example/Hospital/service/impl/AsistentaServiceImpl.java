package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Asistenta;
import com.example.Hospital.repository.AsistentaRepository;
import com.example.Hospital.service.AsistentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistentaServiceImpl implements AsistentaService {


    private AsistentaRepository asistentaRepository;

    @Autowired
    public AsistentaServiceImpl(AsistentaRepository asistentaRepository) {
        this.asistentaRepository = asistentaRepository;
    }

    @Override
    public List<Asistenta> getAllAsistenta() {
        return asistentaRepository.findAll();
    }

    @Override
    public Asistenta getAsistentaById(Long id) {
        Optional<Asistenta> asistenta = asistentaRepository.findById(id);

         return asistenta.get();

    }

    @Override
    public Asistenta saveAsistenta(Asistenta asistenta) {
       return asistentaRepository.save(asistenta);
    }

    @Override
    public void deleteAsistenta(Long id) {
        Optional<Asistenta> asistentaOptional = asistentaRepository.findById(id);
        if(asistentaOptional.isEmpty()) {
            throw new RuntimeException("No such Asistenta");
        }
        asistentaRepository.deleteById(id);
    }

    @Override
    public void updateAsistenta(Long id,Asistenta asistenta) {
            Optional<Asistenta> asistentaOptional = asistentaRepository.findById(id);
            if(asistentaOptional.isEmpty()) {
                throw new RuntimeException("No such Asistenta");
            }else {
                Asistenta asistenta1 = asistentaOptional.get();
               // asistenta1.setNume(asistenta.getNume());
               // asistenta1.setPrenume(asistenta.getPrenume());
                asistentaRepository.save(asistenta1);
            }

    }
}
