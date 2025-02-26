package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import lombok.RequiredArgsConstructor;

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
            Random r = new Random();
                for (int i = 0; i < 4; i++) {
                    newSong.getColor().add(r.nextInt(255)+1);
                }
            songRepository.save(newSong);
            response = "This song was successfully created";
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
                response = "This song was successfully created ";
            }

        }

        return response;
    }

    public String delete(long id) {
        Song s = songRepository.findById(id).orElse(null);
        String response = "";
        if (s != null) {
            songRepository.delete(s);
            response = "This song was successfully deleted ";
        } else {
            response = "There is not a song with such id";
        }
        return response;
    }

        public ResponseEntity<List<SongDtoResponseGetAll>> getAll() {
            ResponseEntity<List<SongDtoResponseGetAll>> respuesta;
            List<SongDtoResponseGetAll> songList = new ArrayList<SongDtoResponseGetAll>();
            try {
                for (Song s : songRepository.findAll()) {
                    songList.add(SongDtoResponseGetAll.songToSongDTO(s));
                }
                respuesta = ResponseEntity.ok().body(songList);
            } catch (Exception e) {
                respuesta = ResponseEntity.internalServerError().body(null);
            }
            return respuesta;

        }

        public ResponseEntity<SongDtoResponseDetails> getDetails ( long id){

            ResponseEntity<SongDtoResponseDetails> response;

            try {
                Song s;
                s = songRepository.findById(id).orElse(null);

                if (s != null) {
                    response = ResponseEntity.ok().body(SongDtoResponseDetails.songToCSongDTO(s));
                } else {
                    response = ResponseEntity.badRequest().body(null);
                }

            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(null);
            }
            return response;
        }

        public ResponseEntity<String> update (SongDtoRequestUpdate sDTO){
            ResponseEntity<String> response;
            Song modSong;
            try {
                modSong = songRepository.findById(sDTO.getId()).orElse(null);
                System.out.println(sDTO);
                if (modSong != null) {
                    modSong = SongDtoRequestUpdate.songDTOtoSong(sDTO);
                    songRepository.save(modSong);
                    response = ResponseEntity.ok().body("Song data updated");
                } else {
                    response = ResponseEntity.badRequest().body("That song doesn't exist");
                }

            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body("Something went wrong on the Server side");
            }
            return response;
        }
    }
