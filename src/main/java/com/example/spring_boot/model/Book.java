package com.example.spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private boolean isPartOfSeries;
    private int numberInSeries;
    private String seriesName;
    @Indexed
    private String author;
    @Indexed
    private String genre;
    @Indexed
    private double rating;
    private int pagesNumber;
    private int numberOfReviews;

    public Book(String title, boolean isPartOfSeries, int numberInSeries, String seriesName, String author, String genre, double rating, int pagesNumber, int numberOfReviews){
        this.title = title;
        this.isPartOfSeries = isPartOfSeries;
        this.numberInSeries = numberInSeries;
        this.seriesName = seriesName;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.pagesNumber = pagesNumber;
        this.numberOfReviews = numberOfReviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsPartOfSeries(){
        return isPartOfSeries;
    }
    public void setIsPartOfSeries(boolean isPartOfSeries){
        this.isPartOfSeries = isPartOfSeries;
    }

    public int getNumberInSeries() {
        return numberInSeries;
    }

    public void setNumberInSeries(int numberInSeries) {
        this.numberInSeries = numberInSeries;
    }
    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
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

    public double getRating() {
        return pagesNumber;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
}
