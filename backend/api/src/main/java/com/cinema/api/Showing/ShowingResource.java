package com.cinema.api.Showing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/showings")
public class ShowingResource {
    private final ShowingService showingService;

    @Autowired
    public ShowingResource(ShowingRepository showingRepository) {
        this.showingService = new ShowingService(showingRepository);
    }

    @GetMapping("/all")
    public List<Showing> getAll() {
        return showingService.getAllShowings();
    }

    @GetMapping("/{showingId}")
    public Optional<Showing> getShowingById(@PathVariable("showingId") String showingId) {
        return showingService.getShowingById(showingId);
    }

    @GetMapping("/movie/{movieId}")
    public Optional<Showing> getShowingByMovieId(@PathVariable("movieId") String movieId) {
        return showingService.getShowingByMovieId(movieId);
    }

    @GetMapping("/date/{date}")
    public List<Showing> getShowingsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return showingService.getShowingsByDate(date);
    }
}
