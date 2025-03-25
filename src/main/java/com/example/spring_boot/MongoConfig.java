package com.example.spring_boot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}") // read URI from properties
    private String mongoUri;

    @Value("${spring.data.mongodb.database}") // read database name
    private String databaseName;

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(mongoUri);
    }
    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient){
        return mongoClient.getDatabase(databaseName);
    }
}
