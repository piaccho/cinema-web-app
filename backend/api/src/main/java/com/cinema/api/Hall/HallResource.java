package com.cinema.api.Hall;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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