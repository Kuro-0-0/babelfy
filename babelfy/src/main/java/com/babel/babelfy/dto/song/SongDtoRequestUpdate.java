package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Artist;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class SongDtoRequestUpdate {

    private long id;
    private String name;
    private int duration;
    private String albumName;
    private LocalDate releaseDate;
    private long categoryId;


}
