package com.cinema.api.repository;

import com.cinema.api.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface GenreRepository
        extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);
}
