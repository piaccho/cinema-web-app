package com.cinema.api.Repertoire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RepertoireService {
    private final RepertoireRepository repertoireRepository;

    @Autowired
    public RepertoireService(RepertoireRepository repertoireRepository) {
        this.repertoireRepository = repertoireRepository;
    }

    public List<Repertoire> insertAll(List<Repertoire> repertoires) {
        List<Repertoire> insertedRepertoires = new ArrayList<>();
        for (Repertoire repertoire : repertoires) {
            Optional<Repertoire> existingRepertoire = repertoireRepository.findByRepertoireId(repertoire.getRepertoireId());

            if (existingRepertoire.isPresent()) {
                insertedRepertoires.add(existingRepertoire.get());
            } else {
                insertedRepertoires.add(repertoireRepository.insert(repertoire));
            }
        }

        return insertedRepertoires;
    }

    public Repertoire insert(Repertoire repertoire) {
        return repertoireRepository.findByRepertoireId(repertoire.getRepertoireId()).orElseGet(() -> repertoireRepository.insert(repertoire));
    }

    public List<Repertoire> getAllRepertoires() {
        return repertoireRepository.findAll();
    }

    public Optional<Repertoire> getRepertoireById(String repertoireId) {
        return repertoireRepository.findByRepertoireId(repertoireId);
    }
}
