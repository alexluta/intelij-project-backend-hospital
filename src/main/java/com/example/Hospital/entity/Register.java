package com.example.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {
@Id
    int id;
    String username;
    String email;
    String password;

}
