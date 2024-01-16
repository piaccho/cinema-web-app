package com.cinema.api.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/reservations")
public class ReservationResource {
    private final ReservationService reservationService;

    @Autowired
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
