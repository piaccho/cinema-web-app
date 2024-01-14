package com.cinema.api.User;


import com.cinema.api.Movie.Movie;
import com.cinema.api.Reservation.Reservation;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String type;
    private String login;
    private String password;
    private String name;
    private String lastname;
    @DBRef
    private List<Movie> to_watch = new ArrayList<>();
    @DBRef
    private List<Reservation> reservations = new ArrayList<>();

    public User(String userId, String type, String login, String password, String name, String lastname, List<Movie> to_watch, List<Reservation> reservations) {
        this.userId = userId;
        this.type = type;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.to_watch = to_watch;
        this.reservations = reservations;
    }
}