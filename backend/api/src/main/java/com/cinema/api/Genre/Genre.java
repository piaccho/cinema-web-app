package com.cinema.api.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    @Id
    private String genreId;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
