package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class SongDtoResponseDetails {


    private String name;
    private long id;
    private int duration;
    private List<String> artistList;
    private List<Long> artistsIDList;
    private String albumName;
    private LocalDate releaseDate;
    private String categoryName;
    private long categoryID;

    public static SongDtoResponseDetails songToCSongDTO(Song s) {
        String categoryName;
        long categoryID;
        List<String> artistList = new ArrayList<>();
        List<Long> artistsIDList= new ArrayList<>();

        if (s.getCategory() != null) {
            categoryName = s.getCategory().getName();
            categoryID = s.getCategory().getId();
        } else {
            categoryName = "None";
            categoryID = -1;
        }

        for (Artist a : s.getArtists()) {
            artistList.add(a.getName());
            artistsIDList.add(a.getId());
        }

        return SongDtoResponseDetails.builder()
                .name(s.getName())
                .id(s.getId())
                .duration(s.getDuration())
                .artistList(artistList)
                .artistsIDList(artistsIDList)
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .categoryName(categoryName)
                .categoryID(categoryID)
                .build();
    }
}