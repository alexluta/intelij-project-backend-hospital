package com.example.Hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="salon")
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numarSalon;

    private int capacitate;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pacient> pacienti;

    @ManyToOne
    @JoinColumn(name = "sectie_id", nullable = false)
    private Sectie sectie;

}
