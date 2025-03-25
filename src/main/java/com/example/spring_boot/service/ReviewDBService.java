package com.example.spring_boot.service;

import com.example.spring_boot.model.Review;
import com.example.spring_boot.model.Book;
import com.example.spring_boot.repository.ReviewRepository;
import com.example.spring_boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private void updateBookRating(String bookId, double rating){
        Book book = bookRepository.getBookById(bookId);
        double currentTotalRating = book.getRating() * book.getNumberOfReviews();
        double newTotalRating = currentTotalRating + rating;
        int newNumberOfReviews = book.getNumberOfReviews() + 1;
        double newAverageRating = newTotalRating / newNumberOfReviews;

        book.setRating(newAverageRating);
        book.setNumberOfReviews(newNumberOfReviews);
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
}
