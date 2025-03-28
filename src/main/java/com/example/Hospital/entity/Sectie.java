package com.example.Hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore

    @OneToMany(mappedBy = "sectie")
    private List<Medic> medici;

    @OneToMany(mappedBy = "sectie")
    private List<Asistenta> asistente;

    @JsonBackReference
    @OneToMany(mappedBy = "sectie")
    private List<Salon> saloane;

}
