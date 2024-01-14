package com.cinema.api.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private final MovieService movieService;

    public MovieResource(MovieRepository movieRepository) {
        this.movieService = new MovieService(movieRepository);
    }

    @GetMapping("/all")
    public List<Movie> getAll() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }
}
