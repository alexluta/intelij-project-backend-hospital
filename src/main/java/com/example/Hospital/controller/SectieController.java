package com.example.Hospital.controller;

import com.example.Hospital.entity.Sectie;
import com.example.Hospital.service.SectieService;
import com.example.Hospital.service.impl.SectieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectieController {

    private SectieServiceImpl sectieServiceImpl;

    @Autowired
    public SectieController(SectieServiceImpl sectieServiceImpl) {
        this.sectieServiceImpl = sectieServiceImpl;
    }

    @PostMapping("/saveSectie")
    public ResponseEntity<Sectie> createSectie(@RequestBody Sectie sectie) {
        Sectie sectie1 = sectieServiceImpl.saveSectie(sectie);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectie);
    }

    @DeleteMapping("/deleteSectie/{id}")
    public ResponseEntity<Void> deleteSectie(@PathVariable Long id) {
        sectieServiceImpl.deleteSectie(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifySectie/{id}")
    public ResponseEntity<Void> updateSectie(@PathVariable Long id,@RequestBody Sectie sectie) {
        sectieServiceImpl.updateSectie(id,sectie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectSectie/{id}")
    public ResponseEntity<Sectie> getSectie(@PathVariable Long id) {
        Sectie sectie = sectieServiceImpl.getSectieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(sectie);
    }

}
