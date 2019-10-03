package com.example.bookservice.movieservice.controller;

import com.example.bookservice.movieservice.client.BookServiceClient;
import com.example.bookservice.movieservice.client.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies/books")
public class BookServiceController {

    private final BookServiceClient bookServiceClient;

    public BookServiceController(BookServiceClient bookServiceClient) {
        this.bookServiceClient = bookServiceClient;
    }

    @GetMapping
    public List<Book> findAllBooks() {
        log.info("Find all books from movie-service.");
        return bookServiceClient.findAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        log.info("Find all book by id: " + bookId + " from movie-service");
        return bookServiceClient.findBook(bookId);
    }
}
