package com.jakuza.tvseries.repository;

import com.jakuza.tvseries.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveOneSimple(){
        Series knight_rider = Series.builder()
                .title("Knight Rider")
                .releaseYear(1982)
                .endYear(1986)
                .build();
        seriesRepository.save(knight_rider);

        List<Series> seriesList = seriesRepository.findAll();
        assertThat(seriesList).hasSize(1);
    }

    @Test
    public void transientIsNotSaved(){
        Series knight_rider = Series.builder()
                .title("Knight Rider")
                .releaseYear(1982)
                .endYear(1986)
                .build();
        knight_rider.calculateDuration();
        assertThat(knight_rider.getDuration()).isEqualTo(4);
        seriesRepository.save(knight_rider);
        testEntityManager.clear();
        List<Series> seriesList = seriesRepository.findAll();
        assertThat(seriesList).allMatch(series -> series.getDuration() == 0L);

    }

}