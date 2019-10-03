package com.example.bookservice.controller;

import com.example.bookservice.client.model.Movie;
import com.example.bookservice.client.MovieServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books/movies")
public class MoviesServiceController {

    private final MovieServiceClient movieServiceClient;

    public MoviesServiceController(MovieServiceClient movieServiceClient) {
        this.movieServiceClient = movieServiceClient;
    }

    @GetMapping
    public List<Movie> findAllMovies() {
        log.info("Find all movies from book-service.");
        return movieServiceClient.findAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie findMovie(@PathVariable Long movieId) {
        log.info("Find all movie by id: " + movieId + " from book-service.");
        return movieServiceClient.findMovie(movieId);
    }
}
