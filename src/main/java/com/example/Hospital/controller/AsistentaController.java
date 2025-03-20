package com.example.Hospital.controller;

import com.example.Hospital.entity.Asistenta;
import com.example.Hospital.entity.Medic;
import com.example.Hospital.service.AsistentaService;
import com.example.Hospital.service.impl.AsistentaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AsistentaController {

    //Http verbs: GET,PUT,DELETE,UPDATE,PATCH
    //Status code: 404 not found, 200 ok, 201 created,

    private AsistentaServiceImpl asistentaServiceImpl;

    @Autowired
    public AsistentaController(AsistentaServiceImpl asistentaServiceImpl) {
        this.asistentaServiceImpl = asistentaServiceImpl;
    }

    @PostMapping("/saveAsistenta")
    public ResponseEntity<Asistenta> createAsistenta(@RequestBody Asistenta asistenta) {
        Asistenta asistenta1 = asistentaServiceImpl.saveAsistenta(asistenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenta1);
    }


    @DeleteMapping("/deleteAsistenta/{id}")
    public ResponseEntity<Void> deleteAsistenta(@PathVariable Long id) {
        asistentaServiceImpl.deleteAsistenta(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PutMapping("/modifyAsistenta/{id}")
    public ResponseEntity<Void> updateAsistenta(@PathVariable Long id,@RequestBody Asistenta asistenta) {
        asistentaServiceImpl.updateAsistenta(id,asistenta);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/selectAsistenta/{id}")
    public ResponseEntity<Asistenta> getAsistenta(@PathVariable Long id) {
        Asistenta asistenta = asistentaServiceImpl.getAsistentaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(asistenta);
    }
    // Endpoint pentru raportul asistentelor
    @GetMapping("/raportAsistente")
    public ResponseEntity<List<Asistenta>> getRaportAsistente() {
        List<Asistenta> asistente = asistentaServiceImpl.getAllAsistenta();  // Apelează metoda corectă
        return ResponseEntity.status(HttpStatus.OK).body(asistente);
    }

}
