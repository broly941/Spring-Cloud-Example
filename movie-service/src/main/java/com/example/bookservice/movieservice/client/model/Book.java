package com.example.bookservice.movieservice.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;
}
