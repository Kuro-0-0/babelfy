package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.model.Category;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.CategoryRepository;
import com.babel.babelfy.repository.SongRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository songRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Song SongDtoToSong(SongDtoRequestCreate songDto){
        System.out.println(songDto);
        Category c=categoryRepository.findById(songDto.getIdCategory()).orElse(null);
        return Song.builder()
                .name(songDto.getName())
                .duration(songDto.getDuration())
                .artistName(songDto.getArtistName())
                .albumName(songDto.getAlbumName())
                .releaseDate(songDto.getReleaseDate())
                .category(c)
                .build();
    }

    @Transactional
    public String add(SongDtoRequestCreate cDTO) {
        String response = "";
        Song newSong = SongDtoToSong(cDTO);
        List<Song> list = songRepository.findByName(newSong.getName());
        boolean isHereArtist = false;
        if (list.isEmpty()) {
            songRepository.save(newSong);
            newSong.getCategory().getList().add(newSong);
            response = "This song was successfully created";
        } else {

            for (int i = 0; i < list.size() && !isHereArtist; i++) {
                if (list.get(i).getArtistName().equalsIgnoreCase(newSong.getArtistName())) {
                    isHereArtist = true;
                }
            }
            if (isHereArtist) {
                response = "This artist already has a song named like this";
            } else {
                songRepository.save(newSong);
                newSong.getCategory().getList().add(newSong);
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
