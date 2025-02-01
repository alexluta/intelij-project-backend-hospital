package com.example.Hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sectie")
public class Sectie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String denumire;

    @OneToMany(mappedBy = "sectie")
    private List<Medic> medici;

    @OneToMany(mappedBy = "sectie")
    private List<Asistenta> asistente;

    @OneToMany(mappedBy = "sectie")
    private List<Salon> saloane;

}
