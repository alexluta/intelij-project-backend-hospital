package com.example.Hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nume;
    private String prenume;
    private int varsta;
    private String cnp;
    private String diagnostic;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)  // Definește coloana care va face legătura cu Salon
    private Salon salon;  // Referința la Salon
}
