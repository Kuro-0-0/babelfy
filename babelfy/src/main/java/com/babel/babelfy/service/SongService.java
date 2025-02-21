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
        String response="";
        Song newSong = SongDtoRequestCreate.SongDtoToSong(cDTO);
        List<Song> list = songRepository.findByName(newSong.getName());
        boolean isHere=false;

        System.out.println(list);
        System.out.println(newSong);
        if(list.isEmpty()){
            
            songRepository.save(newSong);
            response="This song was created successfully";
        }else {

            for (int i = 0; i < list.size()&&!isHere; i++) {
                if(list.get(i).getArtistName().equalsIgnoreCase(newSong.getArtistName())){
                    isHere=true;
                }
            }
            if(isHere){
                response="This artist already has a song name like this";
            }else{
                songRepository.save(newSong);
                response="This song was created successfully";
            }

        }
        
        return response;
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
