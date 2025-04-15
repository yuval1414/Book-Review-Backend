package com.example.spring_boot.controller;

import com.example.spring_boot.model.Book;
import com.example.spring_boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/allTitles")
    public List<String> findAllBookTitles(){
        return bookService.getAllBooksTitles();
    }
    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBookByAuthor(author);
    }
    @GetMapping("/rating/{rating}")
    public List<Book> getBookByRating (@PathVariable int rating){

        return bookService.getBookByRating(rating);
    }
    @GetMapping("genre/{genre}")
    public List<Book> getBookByGenre(@PathVariable String genre){

        return bookService.getBookByGenre(genre);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
        try{
            Book result = bookService.getBookByTitle(title);
            if(result == null)throw new Exception("title not found");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){ // doesn't show anything in postman!!!!!!!!
            System.err.println(" Occurred: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
