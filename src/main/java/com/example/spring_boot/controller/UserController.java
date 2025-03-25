package com.example.spring_boot.controller;

import com.example.spring_boot.model.User;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            User savedUser = userService.addUser(user);
            return ResponseEntity.ok(savedUser);
        } catch(DuplicateKeyException e){
            return ResponseEntity.badRequest().body("Error: Username already exists.");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        if(user == null){
            return ResponseEntity.badRequest().body("User not found.");
        }
        return ResponseEntity.ok(user);
    }
}
