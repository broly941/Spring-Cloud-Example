package com.example.bookservice.movieservice.client;

import com.example.bookservice.movieservice.client.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class BookServiceClientFallback implements BookServiceClient {

    @Override
    public List<Book> findAllBooks() {
        log.error("Error during invoke findAllBooks() from movie-service");
        return null;
    }

    @Override
    public Book findBook(Long bookId) {
        log.error("Error during invoke findBook() from movie-service");
        return null;
    }
}
