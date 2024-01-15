package com.cinema.api.Hall;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "halls")
@Getter
@Setter
@NoArgsConstructor
public class Hall {
    @Id
    private String hallId;
    private int seatsNumber;
    private int hallNumber;

    public Hall(int seatsNumber, int hallNumber) {
        this.seatsNumber = seatsNumber;
        this.hallNumber = hallNumber;
    }
}
