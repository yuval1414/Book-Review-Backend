package com.example.spring_boot.controller;

import com.example.spring_boot.model.Book;
import com.example.spring_boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
