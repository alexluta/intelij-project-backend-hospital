package com.example.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vw_saloane")
public class RaportSaloane {
    @Id
    private Integer id;  // Cheia primară

    private Integer numarSalon;
    private String denumireSectie;
    private Integer capacitateSalon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenumireSectie() {
        return denumireSectie;
    }

    public void setDenumireSectie(String denumireSectie) {
        this.denumireSectie = denumireSectie;
    }

    public Integer getNumarSalon() {
        return numarSalon;
    }

    public void setNumarSalon(Integer numarSalon) {
        this.numarSalon = numarSalon;
    }

    public Integer getCapacitateSalon() {
        return capacitateSalon;
    }

    public void setCapacitateSalon(Integer capacitateSalon) {
        this.capacitateSalon = capacitateSalon;
    }
}
