package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import com.cinema.api.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private final MovieService movieService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MovieResource(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieService = new MovieService(movieRepository);
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public List<Movie> getAll() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/popular")
    public List<Movie> getTop20Movies() {
        return movieService.getTop20Movies();
    }

    @GetMapping("/upcoming")
    public List<Movie> getTop20Upcoming() {
        return movieService.getTop20Upcoming();
    }

    @GetMapping("/genre/id/{categoryId}")
    public List<Movie> getMoviesByCategoryId(@PathVariable("categoryId") String categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return movieService.getMoviesByCategories(Collections.singletonList(category));
        } else {
            return Collections.emptyList();
        }
    }
    @GetMapping("/category/name/{categoryName}")
    public List<Movie> getMoviesByCategoryName(@PathVariable("categoryName") String categoryName) {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        System.out.println(categoryOptional);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return movieService.getMoviesByCategories(Collections.singletonList(category));
        } else {
            return Collections.emptyList();
        }
    }
    @GetMapping("/search")
    public List<Movie> getMoviesBySearchQuery(@RequestParam(required = true, defaultValue = "") String query) {
        return movieService.getMoviesBySearchQuery(query);
    }
}
