package com.example.Hospital.service;

import com.example.Hospital.entity.User;

public interface RegisterService {
    User registerUser(String email, String password);
}
