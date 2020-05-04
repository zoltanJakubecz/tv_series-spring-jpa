package com.jakuza.tvseries.repository;

import com.jakuza.tvseries.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    
}
