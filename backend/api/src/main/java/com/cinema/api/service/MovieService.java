package com.cinema.api.service;

import com.cinema.api.model.Movie;
import com.cinema.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> insertAll(List<Movie> movies) {
        return movieRepository.insert(movies);
    }

    public Movie insert(Movie movie) {
        return movieRepository.findByTitle(movie.getTitle()).orElse(movieRepository.insert(movie));
    }
}
