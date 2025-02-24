package com.babel.babelfy.service;

import com.babel.babelfy.dto.SongDTO;
import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
import com.babel.babelfy.dto.song.SongDTOResponseDetails;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

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

    public ResponseEntity<SongDTOResponseDetails> getDetails(long id) {

        ResponseEntity<SongDTOResponseDetails> response;

        try {
            Song s;
            s = songRepository.findById(id).orElse(null);

            if (s != null) {
                response = ResponseEntity.ok().body(SongDTOResponseDetails.songToCSongDTO(s));
            } else {
                response = ResponseEntity.badRequest().body(null);
            }

        }
        catch (Exception e) {
            response = ResponseEntity.internalServerError().body(null);
        }
        return response;
    }
}
