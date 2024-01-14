package com.cinema.api.Reservation;


import com.cinema.api.Showing.Showing;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    private String reservationId;
    private Showing showing;

    public Reservation(String reservationId, Showing showing) {
        this.reservationId = reservationId;
        this.showing = showing;
    }
}