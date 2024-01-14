package com.cinema.api.Repertoire;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RepertoireRepository extends MongoRepository<Repertoire, String> {
    Optional<Repertoire> findByRepertoireId(String repertoireId);
}