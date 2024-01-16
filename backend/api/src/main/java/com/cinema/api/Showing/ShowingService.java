package com.cinema.api.Showing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {
    private final ShowingRepository showingRepository;

    @Autowired
    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public List<Showing> insertAll(List<Showing> showings) {
        List<Showing> insertedShowings = new ArrayList<>();
        for (Showing showing : showings) {
            Optional<Showing> existingShowing = showingRepository.findByShowingId(showing.getShowingId());

            if (existingShowing.isPresent()) {
                insertedShowings.add(existingShowing.get());
            } else {
                insertedShowings.add(showingRepository.insert(showing));
            }
        }

        return insertedShowings;
    }

    public Showing insert(Showing showing) {
        return showingRepository.findByShowingId(showing.getShowingId()).orElseGet(() -> showingRepository.insert(showing));
    }

    public List<Showing> getAllShowings() {
        return showingRepository.findAll();
    }

    public Optional<Showing> getShowingById(String showingId) {
        return showingRepository.findByShowingId(showingId);
    }

    public List<Showing> getShowingsByDate(LocalDate date) {
        return showingRepository.findByDatetimeAfterOrderByDatetimeDesc(date.atTime(0, 0));
    }

    public Optional<Showing> getShowingByMovieId(String movieId) {
        return showingRepository.findByMovieId(movieId);
    }
}
