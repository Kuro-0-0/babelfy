package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
import com.babel.babelfy.dto.song.SongDtoRequestCreate;

import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public String add(SongDtoRequestCreate cDTO){
        Song newSong = SongDtoRequestCreate.SongDtoToSong(cDTO);
        songRepository.save(newSong);
        return "This song was created successfully";
    }

    public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
        ResponseEntity<List<SongDTOResponseGetAll>> respuesta;
        List<SongDTOResponseGetAll> songList = new ArrayList<SongDTOResponseGetAll>();
        try {
            for ( Song s : songRepository.findAll()) {
                songList.add(SongDTOResponseGetAll.songToSongDTO(s));
            }
            respuesta = ResponseEntity.ok().body(songList);
        } catch (Exception e) {
            respuesta = ResponseEntity.internalServerError().body(null);
        }
        return respuesta;

    }
}
