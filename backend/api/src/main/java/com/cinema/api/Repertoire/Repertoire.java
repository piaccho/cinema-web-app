package com.cinema.api.Repertoire;

import com.cinema.api.Hall.Hall;
import com.cinema.api.Movie.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "repertoires")
@Getter
@Setter
@NoArgsConstructor
public class Repertoire {
    @Id
    private String repertoireId;
    @DBRef
    private Movie movie;
    @DBRef
    private Hall hall;
    private LocalDate date;
    private LocalDateTime datetime;
    private int freeSeats;
    private String type;
    private float price;

    public Repertoire(Movie movie, Hall hall, LocalDate date, LocalDateTime datetime, int freeSeats, String type, float price) {
        this.movie = movie;
        this.hall = hall;
        this.date = date;
        this.datetime = datetime;
        this.freeSeats = freeSeats;
        this.type = type;
        this.price = price;
    }
}
