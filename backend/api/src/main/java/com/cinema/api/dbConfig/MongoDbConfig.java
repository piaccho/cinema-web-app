package com.cinema.api.dbConfig;

import com.cinema.api.Category.Category;
import com.cinema.api.Category.CategoryRepository;
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
    CommandLineRunner runner(MovieRepository movieRepository, CategoryRepository categoryRepository, MongoTemplate mongoTemplate) {
        return args -> {

            ////////
            // TEST
            ////////
            categoryRepository.deleteAll();
            movieRepository.deleteAll();

            Category category1 = new Category("Crime");
            Category category2 = new Category("Drama");
            categoryRepository.findByName(category1.getName())
                    .ifPresentOrElse(s -> System.out.println("Genre" + s + " already exists"),
                            () -> categoryRepository.insert(category1)
                    );
            categoryRepository.findByName(category2.getName())
                    .ifPresentOrElse(s -> System.out.println("Genre" + s + " already exists"),
                            () -> categoryRepository.insert(category2)
                    );


            Movie movie = new Movie(
                    "The Godfather",
                    List.of(category1, category2),
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
