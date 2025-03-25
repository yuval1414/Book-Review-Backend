package com.example.spring_boot.repository;

import com.example.spring_boot.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,String> {

    List<Review> findByUsername(String username);
    List<Review> findByRating(int rating);
    List<Review> findByBookNameIgnoreCase(String bookName); // case insensitive
}
