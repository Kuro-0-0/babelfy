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
    private String categoryName;
    private long categoryID;

    public static SongDtoResponseDetails songToCSongDTO(Song s) {
        String categoryName;
        long categoryID;

        if (s.getCategory() != null ) {
            categoryName = s.getCategory().getName();
            categoryID = s.getCategory().getId();
        } else {
            categoryName = "None";
            categoryID = -1;
        }
        return SongDtoResponseDetails.builder()
                .name(s.getName())
                .duration(s.getDuration())
                .artistName(s.getArtistName())
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .categoryName(categoryName)
                .categoryID(categoryID)
                .build();
    }

}