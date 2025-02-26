package com.babel.babelfy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;
    private List<Integer> color;

    @ManyToOne
    private Category category;
    
    public Song(String name, int duration, String artistName, String albumName, LocalDate releaseDate,
            Category category) {
        this.name = name;
        this.duration = duration;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.category = category;
    }

}
