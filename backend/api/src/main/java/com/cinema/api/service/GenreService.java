package com.cinema.api.service;

import com.cinema.api.model.Genre;
import com.cinema.api.model.Movie;
import com.cinema.api.repository.GenreRepository;
import com.cinema.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> insertAll(List<Genre> genres) {
        List<Genre> insertedGenres = new ArrayList<>();

        for (Genre genre : genres) {
            Optional<Genre> existingGenre = genreRepository.findByName(genre.getName());

            if (existingGenre.isPresent()) {
                insertedGenres.add(existingGenre.get());
            } else {
                insertedGenres.add(genreRepository.insert(genre));
            }
        }

        return insertedGenres;
    }

    public Genre insert(Genre genre) {
        return genreRepository.findByName(genre.getName()).orElseGet(() -> genreRepository.insert(genre));
    }
}
