package com.example.bookservice.client;

import com.example.bookservice.client.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "movie-service")
@RequestMapping("/movies")
public interface MovieServiceClient {
    @GetMapping
    List<Movie> findAllMovies();

    @GetMapping("/{movieId}")
    Movie findMovie(@PathVariable Long movidId);
}
