package com.example.bookservice.movieservice.controller;

import com.example.bookservice.movieservice.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {
    private List<Movie> bookList = Arrays.asList(
            new Movie(1L, "Tim Schimandle", "Step in 2"),
            new Movie(2L, "Slavisa", "Harry Potter")
    );

    @GetMapping
    public List<Movie> findAllMovies() {
        log.info("Find all movies.");
        return bookList;
    }

    @GetMapping("/{movieId}")
    public Movie findMovie(@PathVariable Long movieId) {
        log.info("Find all movie by id: " + movieId);
        return bookList.stream().filter(b -> b.getId().equals(movieId)).findFirst().orElse(null);
    }
}
