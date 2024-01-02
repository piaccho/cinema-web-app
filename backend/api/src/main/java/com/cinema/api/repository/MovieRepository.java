package com.cinema.api.repository;

import com.cinema.api.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository
        extends MongoRepository<Movie, String> {
    Optional<Movie> findByTitle(String title);
}
