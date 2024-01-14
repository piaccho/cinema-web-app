package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    private String movieId;
    private String title;
    @DBRef
    private List<Category> categories;
    private String director;
    private String description;
    private String poster;
    private String releaseDate;
    private String rating;
    private int runtime;
    private LocalDateTime createdAt;

    public Movie(String title, List<Category> categories, String director, String description, String poster, String releaseDate, String rating, int runtime, LocalDateTime createdAt) {
        this.title = title;
        this.categories = categories;
        this.director = director;
        this.description = description;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.runtime = runtime;
        this.createdAt = createdAt;
    }
}
