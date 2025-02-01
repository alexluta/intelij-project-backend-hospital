package com.example.Hospital.service;


import com.example.Hospital.entity.Asistenta;

import java.util.List;

public interface AsistentaService {
    List<Asistenta> getAllAsistenta();
    Asistenta getAsistentaById(Long id);
    Asistenta saveAsistenta(Asistenta asistenta);
    void deleteAsistenta(Long id);
    void updateAsistenta(Long id,Asistenta asistenta);
}
