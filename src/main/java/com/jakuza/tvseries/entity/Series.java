package com.jakuza.tvseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private long releaseYear;

    private long endYear;

    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Season> seasons;

    @Transient
    private long duration;

    public void calculateDuration(){
        if(endYear != 0L){
            duration = endYear - releaseYear;
        }
    }
}
