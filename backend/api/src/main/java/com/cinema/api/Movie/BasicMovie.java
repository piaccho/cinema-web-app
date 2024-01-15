package com.cinema.api.Movie;

import com.cinema.api.Category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BasicMovie {
    private String movieId;
    private List<Category> categories;
    private String title;
    private String image;
    private int length;
}
