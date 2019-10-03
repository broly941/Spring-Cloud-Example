package com.example.bookservice.movieservice.client;

import com.example.bookservice.movieservice.client.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service", fallback = BookServiceClientFallback.class)
public interface BookServiceClient {
    @GetMapping("/books")
    List<Book> findAllBooks();

    @GetMapping("books/{bookId}")
    Book findBook(@PathVariable Long bookId);
}
