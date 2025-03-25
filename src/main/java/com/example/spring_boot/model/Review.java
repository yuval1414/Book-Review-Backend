package com.example.spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;
    @Indexed
    private String bookId;
    @Indexed
    private String bookName;
    @Indexed
    private String username;
    private String comment;
    @Indexed
    private int rating;
    private boolean containsSpoilers;



    public Review(String bookId, String bookName, String username, String comment, int rating, boolean containsSpoilers ){
        this.bookId = bookId;
        this.bookName = bookName;
        this.username = username;
        this.comment = comment;
        this.rating = rating;
        this.containsSpoilers = containsSpoilers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean getContainsSpoilers() {
        return containsSpoilers;
    }

    public void setContainsSpoilers(boolean containsSpoilers) {
        this.containsSpoilers = containsSpoilers;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
