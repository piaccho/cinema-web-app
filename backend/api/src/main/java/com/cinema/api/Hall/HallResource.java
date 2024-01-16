package com.cinema.api.Hall;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/halls")
public class HallResource {
    private final HallService hallService;

    @Autowired
    public HallResource(HallRepository hallRepository) {
        this.hallService = new HallService(hallRepository);
    }

    @GetMapping("/all")
    public List<Hall> getAll() {
        return hallService.getAllHalls();
    }

    @GetMapping("/{hallId}")
    public Optional<Hall> getHallById(@PathVariable("hallId") String hallId) {
        return hallService.getHallById(hallId);
    }
}