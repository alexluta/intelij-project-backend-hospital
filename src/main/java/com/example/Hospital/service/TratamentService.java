package com.example.Hospital.service;

import com.example.Hospital.entity.Tratament;

import java.util.List;

public interface TratamentService {
    List<Tratament> getAllTratament();
    Tratament getTratamentById(Long id);
    Tratament saveTratament(Tratament tratament);
    void deleteTratament(Long id);
    void updateTratament(Long id, Tratament tratament);
}
