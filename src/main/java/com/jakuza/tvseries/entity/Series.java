package com.jakuza.tvseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

    @Enumerated(EnumType.STRING)
    private Category category;

    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;


    @Transient
    private long duration;

    public void calculateDuration(){
        if(endYear != 0L){
            duration = endYear - releaseYear;
        }
    }

}
