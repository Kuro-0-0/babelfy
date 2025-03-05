package com.babel.babelfy.dto.song;

import java.time.LocalDate;
import java.util.List;

import com.babel.babelfy.model.Song;

import lombok.Data;

@Data
public class SongDtoRequestCreate {

    private String name;
    private int duration;
    private List<Long> artistId;
    private String albumName;
    private LocalDate releaseDate;
    private long idCategory;


    public static SongDtoResponseGetAll songToSongDTO(Song s) {
        return SongDtoResponseGetAll.builder()
                .name(s.getName())
                .build();
    }
}
