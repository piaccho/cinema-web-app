package com.cinema.api.Hall;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HallRepository extends MongoRepository<Hall, String> {
    Optional<Hall> findByHallId(String hallId);
}
