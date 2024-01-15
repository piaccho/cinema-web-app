package com.cinema.api.Showing;

import com.cinema.api.Hall.Hall;
import com.cinema.api.Movie.BasicMovie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShowingData {
    private BasicMovie movie;
    private Hall hall;
    private LocalDateTime datetime;
    private int freeSeats;
    private String type;
    private float price;

}
