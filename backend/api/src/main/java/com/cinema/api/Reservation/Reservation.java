package com.cinema.api.Reservation;


import com.cinema.api.Repertoire.Repertoire;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    private String reservationId;
    @DBRef
    private Repertoire repertoire;

    public Reservation(String reservationId, Repertoire repertoire) {
        this.reservationId = reservationId;
        this.repertoire = repertoire;
    }
}