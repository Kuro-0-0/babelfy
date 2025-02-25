package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.*;

import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.song.SongDtoResponseGetAll;
import com.babel.babelfy.dto.song.SongDtoRequestCreate;

import com.babel.babelfy.dto.song.SongDtoResponseDetails;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository songRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Song songDTOtoSong(SongDtoRequestUpdate sDTO) {

        System.out.println(sDTO);

        return Song.builder()
                .id(sDTO.getId())
                .name(sDTO.getName())
                .duration(sDTO.getDuration())
                .artistName(sDTO.getArtistName())
                .albumName(sDTO.getArtistName())
                .releaseDate(sDTO.getReleaseDate())
                .category(categoryRepository.findById(sDTO.getCategoryId()).orElse(null))
                .build();
    }

    public String add(SongDtoRequestCreate cDTO) {
        String response = "";
        Song newSong = SongDtoRequestCreate.SongDtoToSong(cDTO);
        List<Song> list = songRepository.findByName(newSong.getName());
        boolean isHere = false;
        if (list.isEmpty()) {

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
            ResponseEntity<List<SongDtoResponseGetAll>> response;
            List<SongDtoResponseGetAll> songList = new ArrayList<>();
            try {
                for (Song s : songRepository.findAll()) {
                    songList.add(SongDtoResponseGetAll.songToSongDTO(s));
                }
                response = ResponseEntity.ok().body(songList);
            } catch (Exception e) {
                response = ResponseEntity.internalServerError().body(null);
            }
            return response;

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

        @Transactional
        public ResponseEntity<String> update (SongDtoRequestUpdate sDTO){
            ResponseEntity<String> response = ResponseEntity.internalServerError().body("Something went wrong while processing the data");
            Song modSong;
            try {
                modSong = songRepository.findById(sDTO.getId()).orElse(null);
                System.out.println(sDTO);
                List<Song> artistSongs;
                boolean find = false;
                if (modSong != null) {

                    artistSongs = songRepository.findByArtistName(modSong.getArtistName());

                    if (!artistSongs.isEmpty()) {
                        for (Song s : artistSongs) {
                            if (!find && s.getName().equalsIgnoreCase(modSong.getName()) && s.getId() != sDTO.getId()) {
                                find = true;
                                response = ResponseEntity.badRequest().body("There is already song of that artist with that name.");
                            }
                        }

                        if (!find) {
                            modSong = songDTOtoSong(sDTO);
                            System.out.println(modSong);
                            songRepository.save(modSong);
                            response = ResponseEntity.ok().body("Song data updated");
                        }

                    } else {
                        modSong = songDTOtoSong(sDTO);
                        songRepository.save(modSong);
                        response = ResponseEntity.ok().body("Song data updated");
                    }
                } else {
                    response = ResponseEntity.badRequest().body("That song doesn't exist");
                }

            } catch (Exception e) {
                System.out.println(e);
                response = ResponseEntity.internalServerError().body("Something went wrong on the Server side");
            }
            return response;
        }

}
