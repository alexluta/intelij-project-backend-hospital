package com.example.Hospital.controller;

import com.example.Hospital.entity.RaportSaloane;
import com.example.Hospital.service.RaportSaloaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/raportSaloane")
@CrossOrigin("*")
@RestController
public class RaportSaloaneController {

    private final RaportSaloaneService raportSaloaneService;

    @Autowired
    public RaportSaloaneController(RaportSaloaneService raportSaloaneService) {
        this.raportSaloaneService = raportSaloaneService;
    }

    @GetMapping
    public List<RaportSaloane> getAllSaloane() {
        return raportSaloaneService.getAllRaportSaloane();
    }
}
