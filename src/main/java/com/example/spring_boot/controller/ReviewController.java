package com.example.spring_boot.controller;

import com.example.spring_boot.model.Review;
import com.example.spring_boot.service.ReviewDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    private final ReviewDBService reviewService;

    @Autowired
    public ReviewController(ReviewDBService reviewService){
        this.reviewService = reviewService;
    }
    @PostMapping("/add")
    public Review addReview(@RequestBody Review review){

        return reviewService.addReview(review.getBookId(), review);
    }
    @GetMapping("/user/{username}")
    public List<Review> getReviewByUsername(@PathVariable String username){
        return reviewService.getReviewByUsername(username);
    }
    @GetMapping("/user/myReviews/{username}")
    public List<Map<String, Object>> getReviewAndBookByUsername(@PathVariable String username){
        return reviewService.getReviewAndBookByUsername(username);
    }
    @GetMapping("/rating/{rating}")
    public List<Review> getReviewByRating(@PathVariable int rating){

        return reviewService.getReviewByRating(rating);
    }
    @GetMapping("bookName/{bookName}")
    public List<Review> getReviewByBookName(@PathVariable String bookName){
        return reviewService.getReviewByBookName(bookName);
    }
}
