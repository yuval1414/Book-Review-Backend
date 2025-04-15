package com.example.spring_boot.repository;

import com.example.spring_boot.model.Review;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Map;

public interface ReviewRepository extends MongoRepository<Review,String> {
    @Query("{'username': ?0}")
    List<Review> findByUsername(String username);

    List<Review> findByRating(int rating);
    List<Review> findByBookNameIgnoreCase(String bookName); // case insensitive
   //List<Map<String, Object>> findReviewAndBookByUsername(String username);
}
