package com.cinema.api.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> insertAll(List<Reservation> reservations) {
        List<Reservation> insertedReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            Optional<Reservation> existingReservation = reservationRepository.findByReservationId(reservation.getReservationId());

            if (existingReservation.isPresent()) {
                insertedReservations.add(existingReservation.get());
            } else {
                insertedReservations.add(reservationRepository.insert(reservation));
            }
        }
        return insertedReservations;
    }

    public Reservation insert(Reservation reservation) {
        return reservationRepository.insert(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(String reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }
}