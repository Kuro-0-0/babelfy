package com.babel.babelfy.dto.artist;

import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.dto.song.SongDtoResponseDetails;
import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDtoResponseDetails {

    private String name;
    private List<SongDtoResponseDetails> songs;

        public static ArtistDtoResponseDetails artistToArtistDTO(Artist a) {
            List<SongDtoResponseDetails> listDto = new ArrayList<>();
            for (Song song : a.getSongList()) {
                listDto.add(SongDtoResponseDetails.songToCSongDTO(song));
            }
        return ArtistDtoResponseDetails.builder()
                .name(a.getName())
                .songs(listDto)
                .build();
    }

}
