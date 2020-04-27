package com.jakuza.tvseries.repository;

import com.jakuza.tvseries.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
