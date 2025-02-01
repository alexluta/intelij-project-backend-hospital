package com.example.Hospital.service;

import com.example.Hospital.entity.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    User saveUser(User user);
    User getUserById(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();

    void registerNewUser(String email,String password);
}
