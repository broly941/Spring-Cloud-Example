package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class LibraryController {
    private List<Book> bookList = Arrays.asList(
            new Book(1L, "Tim Schimandle", "Baeldung goes to the market"),
            new Book(2L, "Slavisa", "Baeldung goes to the park")
    );

    @GetMapping
    public List<Book> findAllBooks() {
        log.info("Find all books.");
        return bookList;
    }

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId) {
        log.info("Find all book by id: " + bookId);
        return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
    }
}
