package com.cinema.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("genres")
public class Genre {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
