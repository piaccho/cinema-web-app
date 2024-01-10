package com.cinema.api.Genre;

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

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(String genreId) {
        return genreRepository.findByGenreId(genreId);
    }
}
