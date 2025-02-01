package com.example.Hospital.controller;

import com.example.Hospital.entity.Tratament;
import com.example.Hospital.service.TratamentService;
import com.example.Hospital.service.impl.TratamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TratamentController {

    private TratamentServiceImpl tratamentServiceImpl;

    @Autowired
    public TratamentController(TratamentServiceImpl tratamentServiceImpl){this.tratamentServiceImpl=tratamentServiceImpl;}

    public ResponseEntity<Tratament> createTratament(@RequestBody Tratament tratament){
        Tratament tratament1 = tratamentServiceImpl.saveTratament(tratament);
        return ResponseEntity.status(HttpStatus.CREATED).body(tratament);
    }
    @DeleteMapping("/deleteTratament/{id}")
    public ResponseEntity<Void> deleteTratament(@PathVariable Long id) {
        tratamentServiceImpl.deleteTratament(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/modifyTratament/{id}")
    public ResponseEntity<Void> updateTratament(@PathVariable Long id,@RequestBody Tratament tratament) {
        tratamentServiceImpl.updateTratament(id,tratament);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/selectTratament/{id}")
    public ResponseEntity<Tratament> getTratament(@PathVariable Long id) {
        Tratament tratament = tratamentServiceImpl.getTratamentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tratament);
    }
}
