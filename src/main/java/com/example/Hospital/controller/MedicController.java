package com.example.Hospital.controller;

import com.example.Hospital.entity.Medic;
import com.example.Hospital.service.MedicService;
import com.example.Hospital.service.impl.MedicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicController {

    private MedicServiceImpl medicServiceImpl;

    @Autowired
    public MedicController(MedicServiceImpl medicServiceImpl) {
        this.medicServiceImpl = medicServiceImpl;
    }

    @PostMapping("/saveMedic")
    public ResponseEntity<Medic> createMedic(@RequestBody Medic medic) {
        Medic medic1 = medicServiceImpl.saveMedic(medic);
        return ResponseEntity.status(HttpStatus.CREATED).body(medic);
    }


    @DeleteMapping("/deleteMedic/{id}")
    public ResponseEntity<Void> deleteMedic(@PathVariable Long id) {
        medicServiceImpl.deleteMedic(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifyMedic/{id}")
    public ResponseEntity<Void> updateMedic(@PathVariable Long id,@RequestBody Medic medic) {
        medicServiceImpl.updateMedic(id,medic);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectMedic/{id}")
    public ResponseEntity<Medic> getMedic(@PathVariable Long id) {
        Medic medic = medicServiceImpl.getMedicById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medic);
    }
}
