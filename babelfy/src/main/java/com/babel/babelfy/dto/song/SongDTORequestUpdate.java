package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SongDTORequestUpdate {

    private long id;
    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;

    public static Song songDTOtoSong(SongDTORequestUpdate sDTO) {
        return Song.builder()
                .id(sDTO.id)
                .name(sDTO.name)
                .duration(sDTO.duration)
                .artistName(sDTO.artistName)
                .albumName(sDTO.albumName)
                .releaseDate(sDTO.releaseDate)
                .build();
    }

}
