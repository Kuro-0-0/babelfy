package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
import com.babel.babelfy.dto.song.SongDtoRequestCreate;

import com.babel.babelfy.dto.song.SongDTOResponseDetails;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository songRepository;

    public String add(SongDtoRequestCreate cDTO) {
        String response = "";
        Song newSong = SongDtoRequestCreate.SongDtoToSong(cDTO);
        List<Song> list = songRepository.findByName(newSong.getName());
        boolean isHere = false;
        if (list.isEmpty()) {

            songRepository.save(newSong);
            response = "This song was created successfully";
        } else {

            for (int i = 0; i < list.size() && !isHere; i++) {
                if (list.get(i).getArtistName().equalsIgnoreCase(newSong.getArtistName())) {
                    isHere = true;
                }
            }
            if (isHere) {
                response = "This artist already has a song named like this";
            } else {
                songRepository.save(newSong);
                response = "This song was created successfully";
            }

        }

        return response;
    }

    public String delete(long id) {
        Song s = songRepository.findById(id).orElse(null);
        String response = "";
        if (s != null) {
            songRepository.delete(s);
            response = "This song was deleted successfully";
        } else {
            response = "There is not a song with such id";
        }
        return response;
    }

        public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
            ResponseEntity<List<SongDTOResponseGetAll>> respuesta;
            List<SongDTOResponseGetAll> songList = new ArrayList<SongDTOResponseGetAll>();
            try {
                for (Song s : songRepository.findAll()) {
                    songList.add(SongDTOResponseGetAll.songToSongDTO(s));
                }
                respuesta = ResponseEntity.ok().body(songList);
            } catch (Exception e) {
                respuesta = ResponseEntity.internalServerError().body(null);
            }
            return respuesta;

        }

        public ResponseEntity<SongDTOResponseDetails> getDetails ( long id){

            ResponseEntity<SongDTOResponseDetails> response;

            try {
                Song s;
                s = songRepository.findById(id).orElse(null);

                if (s != null) {
                    response = ResponseEntity.ok().body(SongDTOResponseDetails.songToCSongDTO(s));
                } else {
                    response = ResponseEntity.badRequest().body(null);
                }

            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(null);
            }
            return response;
        }

        public ResponseEntity<String> update (SongDTORequestUpdate sDTO){
            ResponseEntity<String> response;
            Song modSong;
            try {
                modSong = songRepository.findById(sDTO.getId()).orElse(null);
                System.out.println(sDTO);
                if (modSong != null) {
                    modSong = SongDTORequestUpdate.songDTOtoSong(sDTO);
                    songRepository.save(modSong);
                    response = ResponseEntity.ok().body("Song data updated");
                } else {
                    response = ResponseEntity.badRequest().body("That song doesnt exist.");
                }

            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body("Something went wrong on the Server side");
            }
            return response;
        }
    }
