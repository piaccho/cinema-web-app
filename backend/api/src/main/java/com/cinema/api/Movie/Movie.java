package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document("movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    private String movieId;
    private boolean adult;
    private List<Category> categories;
    private String title;
    private String originalTitle;
    private LocalDate releaseDate;
    private String image;
    private String overview;
    private int length;
    private float voteAverage;
    private float voteCount;
    private float popularity;
    private String originalLanguage;

    public Movie(boolean adult, List<Category> categories, String title, String originalTitle,
                 LocalDate releaseDate, String image, String overview, int length,
                 float voteAverage, float voteCount, float popularity, String originalLanguage) {
        this.adult = adult;
        this.categories = categories;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
        this.image = image;
        this.overview = overview;
        this.length = length;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
    }
}
