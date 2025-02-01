package com.example.Hospital.controller;

import com.example.Hospital.entity.User;
import com.example.Hospital.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
      this.userServiceImpl = userServiceImpl;
    }
    @PostMapping("/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userServiceImpl.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/modifyUser/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@RequestBody User user) {
        userServiceImpl.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/selectUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}
