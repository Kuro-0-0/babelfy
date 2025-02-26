package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SongDtoResponseDetails {

    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;

    public static SongDtoResponseDetails songToCSongDTO(Song s) {
        return SongDtoResponseDetails.builder()
                .name(s.getName())
                .duration(s.getDuration())
                .artistName(s.getArtistName())
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .build();
    }

}