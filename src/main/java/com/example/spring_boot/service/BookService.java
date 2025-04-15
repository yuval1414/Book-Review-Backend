package com.example.spring_boot.service;

import com.example.spring_boot.model.Book;
import com.example.spring_boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public List<String> getAllBooksTitles(){
        return bookRepository.findAllBookTitles().stream()
                .map(titleJson -> titleJson.replaceAll("^\\{\"title\":\\s*\"|\"}$", ""))
                .collect(Collectors.toList());
    }
    public List<Book> getBookByAuthor(String author){

        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBookByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBookByRating(double rating){

        return bookRepository.findByRating(rating);
    }

    public Book getBookByTitle(String title){
        Book book = null;
        book = bookRepository.findByTitleIgnoreCase(title);
        if (book == null) {
            throw new DuplicateKeyException("book doesn't exists");
        }
        return book;
    }

    public Book getBookById(String id){
        Book book = bookRepository.getBookById(id);
        if(book.getId() == null){
            throw new DuplicateKeyException("book doesn't exists");
        }
        return book;
    }


}
