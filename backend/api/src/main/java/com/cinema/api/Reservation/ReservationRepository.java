package com.cinema.api.Reservation;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    Optional<Reservation> findByReservationId(String reservationId);
}
