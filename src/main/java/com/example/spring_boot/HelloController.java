package com.example.spring_boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {

    @GetMapping("/SearchReview")
    public  ResponseEntity<ResponseMessage> getSearchReview() {
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Greetings from Spring Boot!");
//        return response;
        ResponseMessage response = new ResponseMessage(201,"Data saved successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
