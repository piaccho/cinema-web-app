package com.cinema.api.dbConfig;

import com.cinema.api.Category.CategoryRepository;
import com.cinema.api.Hall.HallRepository;
import com.cinema.api.Movie.MovieRepository;
import com.cinema.api.Reservation.ReservationRepository;
import com.cinema.api.Showing.ShowingRepository;
import com.cinema.api.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig {
    @Bean
    CommandLineRunner runner(
            CategoryRepository categoryRepository,
            HallRepository hallRepository,
            MovieRepository movieRepository,
            ReservationRepository reservationRepository,
            ShowingRepository showingRepository,
            UserRepository userRepository,
            MongoTemplate mongoTemplate) {

        return args -> {
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<GenreData> categoryDataList = objectMapper.readValue(
//                    new File("to_insert/genres.json"),
//                    new TypeReference<List<GenreData>>() {}
//            );
//            for (GenreData categoryData : categoryDataList) {
//                Genre genre = new Genre(categoryData.getName());
//                genreRepository.findByName(genre.getName())
//                        .ifPresentOrElse(
//                                s -> System.out.println("Genre " + s + " already exists"),
//                                () -> genreRepository.insert(genre)
//                        );
//            }

            System.out.println("--------");
        };
    }

}
