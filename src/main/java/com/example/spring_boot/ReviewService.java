package com.example.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ReviewService {
    private List<ReviewDTO> reviews = new ArrayList<>();

    public void saveReview(ReviewDTO review){
        reviews.add(review);
    }
    public List<ReviewDTO> getAllReviews() {
        return reviews;
    }
    public ReviewDTO getReviewsByCategory(String category){
        // searching in the list for all reviews with that category
        return null;
    }
}
