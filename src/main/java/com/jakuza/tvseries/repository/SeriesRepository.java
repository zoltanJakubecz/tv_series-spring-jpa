package com.jakuza.tvseries.repository;

import com.jakuza.tvseries.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
