package com.cinema.api.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findByMovieId(movieId);
    }
}
