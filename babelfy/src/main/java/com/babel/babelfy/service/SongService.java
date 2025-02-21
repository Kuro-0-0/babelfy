package com.babel.babelfy.service;

import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.song.SongDtoRequestCreate;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public String add(SongDtoRequestCreate cDTO){
        Song newSong = SongDtoRequestCreate.SongDtoToSong(cDTO);
        songRepository.save(newSong);
        return "This song was created successfully";
    }


}
