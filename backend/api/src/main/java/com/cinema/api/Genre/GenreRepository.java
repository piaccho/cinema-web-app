package com.cinema.api.Genre;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);

    Optional<Genre> findByGenreId(String genreId);
}
