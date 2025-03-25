package com.example.spring_boot.repository;

import com.example.spring_boot.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {

    @Query(value = "{}", fields = "{'title' : 1, '_id' : 0}")
    List<String> findAllBookTitles();
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    List<Book> findByRating(double rating);
    Book getBookByTitle(String title);
    Book getBookById(String id);

}
