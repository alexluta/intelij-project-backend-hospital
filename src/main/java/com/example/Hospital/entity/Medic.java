package com.example.Hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medic")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nume;
    private String prenume;
    private String specializare;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sectie_id")
    private Sectie sectie;
}
