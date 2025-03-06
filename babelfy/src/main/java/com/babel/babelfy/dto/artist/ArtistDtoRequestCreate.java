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
public class ArtistDtoRequestCreate {

    private String name;


    public static Artist artistDtoToArtist(ArtistDtoRequestCreate aDTO) {
        return Artist.builder()
                .name(aDTO.getName())
                .build();
    }
}
