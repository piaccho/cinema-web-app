package com.cinema.api.Movie;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieData {
    private Long id;
    private boolean adult;
    private List<String> genres;
    private String title;
    private String originalTitle;
    private String releaseDate;
    private String image;
    private String overview;
    private double voteAverage;
    private int voteCount;
    private double popularity;
    private String originalLanguage;

}
