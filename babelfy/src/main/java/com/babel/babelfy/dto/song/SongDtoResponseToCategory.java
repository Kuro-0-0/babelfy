package com.babel.babelfy.dto.song;

import java.time.LocalDate;

import com.babel.babelfy.model.Song;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDtoResponseToCategory {

    private long id;
    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;

    public static SongDtoResponseToCategory songToCSongDTO(Song s) {
        return SongDtoResponseToCategory.builder()
                .id(s.getId())
                .name(s.getName())
                .duration(s.getDuration())
                .artistName(s.getArtistName())
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .build();
    }
}