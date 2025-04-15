package com.example.spring_boot.service;

import com.example.spring_boot.model.Review;
import com.example.spring_boot.model.Book;
import com.example.spring_boot.repository.ReviewRepository;
import com.example.spring_boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewDBService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;


    @Autowired
    public ReviewDBService(ReviewRepository reviewRepository, BookRepository bookRepository){
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public Review addReview(String bookId, Review review){
            Book book = bookRepository.getBookById(bookId);

            if (book == null) {
                throw new RuntimeException("Book not found");
            }
            review.setBookId(bookId);
            Review savedReview = reviewRepository.save(review);
            updateBookRating(savedReview.getBookId(), savedReview.getRating());

            return savedReview;
    }
    //----------- NOT WORKING!!!!!!----------------------
    private void updateBookRating(String bookId, double rating){
        Book book = bookRepository.getBookById(bookId);
        //double currentTotalRating = book.getRating() * book.getNumberOfReviews();
        double newTotalRating = book.getRating() + rating;
        //int newNumberOfReviews = book.getNumberOfReviews() + 1;
        double newAverageRating = newTotalRating / 2;

        book.setRating(newAverageRating);
        book.setNumberOfReviews(book.getNumberOfReviews() + 1);
        bookRepository.save(book);
    }

    public List<Review> getReviewByUsername(String username){

        return reviewRepository.findByUsername(username);
    }

    public List<Review> getReviewByRating(int rating){

        return reviewRepository.findByRating(rating);
    }

    public List<Review> getReviewByBookName(String bookName) {
        return reviewRepository.findByBookNameIgnoreCase(bookName);
    }

    public List<Map<String, Object>> getReviewAndBookByUsername(String username) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            List<Review> reviews = reviewRepository.findByUsername(username);
            if(reviews == null){
                throw new IllegalArgumentException("User didn't made any reviews");
            }

            for (Review review : reviews) {
                Map<String, Object> combined = new HashMap<>();
                combined.put("review", review);
                String s = review.getBookName();
                Book book = bookRepository.findByTitleIgnoreCase(s);
                if (book != null) {
                    combined.put("book", book);
                }
                result.add(combined);
            }
        }catch(IllegalArgumentException e){
           System.err.println(e.getMessage());
        }
        return result;
    }
}
