package com.cinema.api.Showing;

import com.cinema.api.Hall.Hall;
import com.cinema.api.Hall.HallData;
import com.cinema.api.Movie.Movie;
import com.cinema.api.Movie.MovieData;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowingData {
    private Movie movie;
    private Hall hall;
    private LocalDate date;
    private LocalDateTime datetime;
    private int freeSeats;
    private String type;
    private float price;

}
