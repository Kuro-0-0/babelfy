package com.babel.babelfy.dto.artist;

import com.babel.babelfy.model.Artist;

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

        public static ArtistDtoResponseDetails artistToArtistDTO(Artist a) {
        return ArtistDtoResponseDetails.builder()
                .name(a.getName())
                .build();
    }

}
