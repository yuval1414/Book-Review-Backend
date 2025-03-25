package com.example.spring_boot.service;

import com.example.spring_boot.model.User;
import com.example.spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new DuplicateKeyException("username already exists");
        }

        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    public User getUserByUsername(String username){

        return userRepository.findByUsername(username);
    }
}
