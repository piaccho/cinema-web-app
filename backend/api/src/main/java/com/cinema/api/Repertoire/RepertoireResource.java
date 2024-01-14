package com.cinema.api.Repertoire;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repertoires")
public class RepertoireResource {
    private final RepertoireService repertoireService;

    public RepertoireResource(RepertoireRepository repertoireRepository) {
        this.repertoireService = new RepertoireService(repertoireRepository);
    }

    @GetMapping("/all")
    public List<Repertoire> getAll() {
        return repertoireService.getAllRepertoires();
    }

    @GetMapping("/{repertoireId}")
    public Optional<Repertoire> getRepertoireById(@PathVariable("repertoireId") String repertoireId) {
        return repertoireService.getRepertoireById(repertoireId);
    }
}
