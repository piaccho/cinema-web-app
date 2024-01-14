package com.cinema.api.Hall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> insertAll(List<Hall> halls) {
        List<Hall> insertedHalls = new ArrayList<>();

        for (Hall hall : halls) {
            Optional<Hall> existingHall = hallRepository.findByHallId(hall.getHallId());

            if (existingHall.isPresent()) {
                insertedHalls.add(existingHall.get());
            } else {
                insertedHalls.add(hallRepository.insert(hall));
            }
        }

        return insertedHalls;
    }

    public Hall insert(Hall hall) {
        return hallRepository.findByHallId(hall.getHallId()).orElseGet(() -> hallRepository.insert(hall));
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Optional<Hall> getHallById(String hallId) {
        return hallRepository.findByHallId(hallId);
    }
}
