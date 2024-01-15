package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Movie> getTop20Movies() {
        LocalDate currentDate = LocalDate.now();
        return movieRepository.findTop20ByReleaseDateBeforeOrderByPopularityDesc(currentDate);
    }

    public List<Movie> getTop20Upcoming() {
        LocalDate currentDate = LocalDate.now();
        return movieRepository.findTop20ByReleaseDateAfterOrderByPopularityDesc(currentDate);
    }

    public List<Movie> getMoviesByCategories(List<Category> categories) {
        return movieRepository.findByCategoriesIn(categories);
    }
}
