package com.cinema.api.Reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationResource {
    private final ReservationService reservationService;

    public ReservationResource(ReservationRepository reservationRepository) {
        this.reservationService = new ReservationService(reservationRepository);
    }

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Optional<Reservation> getReservationById(@PathVariable("reservationId") String reservationId) {
        return reservationService.getReservationById(reservationId);
    }
}
