package com.cinema.api.dbConfig;

import com.cinema.api.Genre.Genre;
import com.cinema.api.Genre.GenreRepository;
import com.cinema.api.Movie.Movie;
import com.cinema.api.Movie.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class MongoDbConfig {
    @Bean
    CommandLineRunner runner(MovieRepository movieRepository, GenreRepository genreRepository, MongoTemplate mongoTemplate) {
        return args -> {

            ////////
            // TEST
            ////////
            genreRepository.deleteAll();
            movieRepository.deleteAll();

            Genre genre1 = new Genre("Crime");
            Genre genre2 = new Genre("Drama");
            genreRepository.findByName(genre1.getName())
                    .ifPresentOrElse(s -> System.out.println("Genre" + s + " already exists"),
                            () -> genreRepository.insert(genre1)
                    );
            genreRepository.findByName(genre2.getName())
                    .ifPresentOrElse(s -> System.out.println("Genre" + s + " already exists"),
                            () -> genreRepository.insert(genre2)
                    );


            Movie movie = new Movie(
                    "The Godfather",
                    List.of(genre1, genre2),
                    "Francis Ford Coppola",
                    "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                    "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg",
                    "24 March 1972",
                    "9.2",
                    175,
                    LocalDateTime.now()
            );

            movieRepository.insert(movie);

            Query query = new Query();
            query.addCriteria(Criteria.where("title").is(movie.getTitle()));
            List<Movie> movies = mongoTemplate.find(query, Movie.class);
            System.out.println(movies);

        };
    }
}
