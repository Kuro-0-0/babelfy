package com.babel.babelfy.dto.artist;

import com.babel.babelfy.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDtoRequestUpdate {

    private long id;
    private String name;

    public static Artist artistDTOToArtist(ArtistDtoRequestUpdate a) {
        return Artist.builder()
                .id(a.getId())
                .name(a.getName())
                .build();
    }
}
