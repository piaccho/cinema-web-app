package com.cinema.api.Showing;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShowingRepository extends MongoRepository<Showing, String> {
    Optional<Showing> findByShowingId(String showingId);

    List<Showing> findByDatetimeAfterOrderByDatetimeDesc(LocalDateTime localDateTime);

    Optional<Showing> findByMovieId(String movieId);
}