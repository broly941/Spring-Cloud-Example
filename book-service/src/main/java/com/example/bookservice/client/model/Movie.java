package com.example.bookservice.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private Long id;
    private String author;
    private String name;
}