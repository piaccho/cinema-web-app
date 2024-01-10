package com.cinema.api.Genre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreResource {
    private GenreService genreService;

    public GenreResource(GenreRepository genreRepository) {
        this.genreService = new GenreService(genreRepository);
    }

    @GetMapping("/all")
    public List<Genre> getAll() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{genreId}")
    public Optional<Genre> getGenreById(@PathVariable("genreId") String genreId) {
        return genreService.getGenreById(genreId);
    }
}
