package com.example.spring_boot;

public class ReviewDTO {
    private int numOfStars;
    private String bookName;
    private Float bookNumberInSeries;
    private String author;
    private String genre;
    private int numberOfPages;
    private String review;

    // Getters and setters
    public int getNumOfStars() {
        return numOfStars;
    }

    public void setNumOfStars(int numOfStars) {
        this.numOfStars = numOfStars;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getBookNumberInSeries() {
        return bookNumberInSeries;
    }

    public void setBookNumberInSeries(String bookNumberInSeries) {
        this.bookNumberInSeries = Float.parseFloat(bookNumberInSeries);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
