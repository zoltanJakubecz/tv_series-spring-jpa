package com.jakuza.tvseries;

import com.jakuza.tvseries.entity.Category;
import com.jakuza.tvseries.entity.Episode;
import com.jakuza.tvseries.entity.Season;
import com.jakuza.tvseries.entity.Series;
import com.jakuza.tvseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Collection;

@SpringBootApplication
public class TvseriesApplication {

    @Autowired
    SeriesRepository seriesRepository;

//    @Autowired
//    SeasonRepository seasonRepository;

    public static void main(String[] args) {
        SpringApplication.run(TvseriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            Episode ki_nyer_ma = Episode.builder()
                    .title("Ki nyer ma vagy holnap")
                    .actor("Kiss Bela")
                    .actor("Lapos Elemer")
                    .actor("Borond Odon")
                    .actor("Zuz Mara")
                    .length("40:20")
                    .build();


            Season kukutyin = Season.builder()
                    .seasonNumber(1)
                    .title("Kukutyin")
                    .episode(ki_nyer_ma)
                    .build();

            Season bukta = Season.builder()
                    .seasonNumber(1)
                    .title("Bukta")
                    .build();

            Series game_of_thrones = Series.builder()
                    .title("Game of Thrones")
                    .releaseYear(2011)
                    .category(Category.ACTION)
                    .endYear(2019)
                    .build();

            seriesRepository.save(game_of_thrones);

            Series knight_rider = Series.builder()
                    .title("Knight Rider")
                    .category(Category.COMEDY)
                    .releaseYear(1982)
                    .endYear(1986)
                    .season(kukutyin)
                    .season(bukta)
                    .build();

            ki_nyer_ma.setSeason(kukutyin);
            kukutyin.setSeries(knight_rider);
            bukta.setSeries(knight_rider);

            seriesRepository.save(knight_rider);
        };
    }

}
