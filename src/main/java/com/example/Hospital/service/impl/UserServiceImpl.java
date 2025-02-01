package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Role;
import com.example.Hospital.entity.User;
import com.example.Hospital.repository.UserRepository;
import com.example.Hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public void registerNewUser(String email, String password) {
        // Verifică dacă utilizatorul există deja
        User existingUser = userRepository.findByEmail(email);


        // Creează un nou utilizator
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Parola trebuie criptată

        // Crează rolul "ROLE_USER"
        Role userRole = new Role("ROLE_USER");

        // Adaugă rolul la utilizator
        user.setRoles(Collections.singletonList(userRole)); // Setează rolul de "ROLE_USER"

        // Salvează utilizatorul în baza de date
        userRepository.save(user);
    }
    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        User user1 = null;
        if(userOptional.isPresent()) {
             user1 = userOptional.get();
        }else {
            throw new RuntimeException("Emailul nu exista.");
        }
        return user1;
    }

    public User saveUser(User user) {
        // Criptarea parolei
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new RuntimeException("Nu exista id-ul.");
        }
        return optionalUser.get();
    }

    @Override
    public void updateUser(Long id, User user) {
            Optional<User> optionalUser = userRepository.findById(id);
            if(!optionalUser.isPresent()){
                throw new RuntimeException("Nu exista userul.");
            }
            User user1 = optionalUser.get();
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new RuntimeException("Nu exista userul.");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
