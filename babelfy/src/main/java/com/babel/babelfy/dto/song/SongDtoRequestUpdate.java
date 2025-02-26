package com.babel.babelfy.dto.song;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SongDtoRequestUpdate {

    private long id;
    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;
    private long categoryId;



}
