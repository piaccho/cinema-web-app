package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByTitle(String title);

    Optional<Movie> findByMovieId(String movieId);

    List<Movie> findTop20ByReleaseDateBeforeOrderByPopularityDesc(LocalDate currentDate);

    List<Movie> findTop20ByReleaseDateAfterOrderByPopularityDesc(LocalDate currentDate);

    List<Movie> findByCategoriesIn(List<Category> categories);

    List<Movie> findByTitleContainingIgnoreCase(String query) ;
}
