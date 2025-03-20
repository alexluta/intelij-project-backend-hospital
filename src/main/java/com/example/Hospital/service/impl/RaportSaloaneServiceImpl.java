package com.example.Hospital.service.impl;

import com.example.Hospital.entity.RaportSaloane;
import com.example.Hospital.entity.User;
import com.example.Hospital.repository.RaportSaloaneRepository;
import com.example.Hospital.service.RaportSaloaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaportSaloaneServiceImpl implements RaportSaloaneService {


    private RaportSaloaneRepository raportSaloaneRepository;

    @Autowired
    public RaportSaloaneServiceImpl(RaportSaloaneRepository raportSaloaneRepository) {
        this.raportSaloaneRepository = raportSaloaneRepository;
    }

    @Override
    public List<RaportSaloane> getAllRaportSaloane() {
        return raportSaloaneRepository.findAll();
    }
}
