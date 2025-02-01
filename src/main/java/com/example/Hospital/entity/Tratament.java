package com.example.Hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tratement")
public class Tratament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String denumire;
    private String descriere;
    private int durata;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

}
