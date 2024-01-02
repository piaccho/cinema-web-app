package com.cinema.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("movies")
public class Movie {
    @Id
    private String id;
    private String title;
    @DBRef
    private List<Genre> genres;
    private String director;
    private String description;
    private String poster;
    private String releaseDate;
    private String rating;
    private int runtime;
    private LocalDateTime createdAt;

    public Movie(String title, List<Genre> genres, String director, String description, String poster, String releaseDate, String rating, int runtime, LocalDateTime createdAt) {
        this.title = title;
        this.genres = genres;
        this.director = director;
        this.description = description;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runtime = runtime;
        this.createdAt = createdAt;
    }
}
