package com.example.spring_boot;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DBController {

    private final MongoDatabase mongoDatabase;

    @Autowired
    public DBController(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @GetMapping("/test")
    public String testConnection() {
        return "Connected to MongoDB: " + mongoDatabase.getName();
    }
}
