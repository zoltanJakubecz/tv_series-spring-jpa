package com.jakuza.tvseries;

import com.jakuza.tvseries.entity.Series;
import com.jakuza.tvseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TvseriesApplication {

    @Autowired
    SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(TvseriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            Series game_of_thrones = Series.builder()
                    .title("Game of Thrones")
                    .releaseYear(2011)
                    .endYear(2019)
                    .build();
            seriesRepository.save(game_of_thrones);
            Series knight_rider = Series.builder()
                    .title("Knight Rider")
                    .releaseYear(1982)
                    .endYear(1986)
                    .build();
            seriesRepository.save(knight_rider);
        };
    }

}
