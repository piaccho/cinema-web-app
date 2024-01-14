package com.cinema.api.Showing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/byDate/{date}")
    public List<Showing> getRepertoiresByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return showingService.getShowingsByDate(date);
    }
}
