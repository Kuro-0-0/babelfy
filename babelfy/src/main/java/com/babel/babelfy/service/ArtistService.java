package com.babel.babelfy.service;

import com.babel.babelfy.dto.artist.ArtistDtoRequestCreate;
import com.babel.babelfy.dto.artist.ArtistDtoResponseGetAll;
import com.babel.babelfy.model.Artist;
import com.babel.babelfy.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ResponseEntity<String> add(ArtistDtoRequestCreate aDTO) {
        ResponseEntity<String> response;
        Artist newArtist;
        Random rnd = new Random();

        try {
            List<Artist> aNames = artistRepository.findByName(aDTO.getName());
            if (aNames.isEmpty()) {
                newArtist = ArtistDtoRequestCreate.artistDtoToArtist(aDTO);
                String values[] = {"A", "B", "C", "D", "E", "F", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                String color = "";

                for (int i = 0; i < 6; i++) {
                    color = color + values[rnd.nextInt(values.length - 1) + 1];
                }
                newArtist.setColor(color);
                artistRepository.save(newArtist);
                response = ResponseEntity.ok("Artist " + aDTO.getName() + " created.");
            } else {
                response = ResponseEntity.badRequest().body
                        ("You can't create this artist because there is already one with that name.");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body
                    ("Something went wrong while creating the artist");
        }

        return response;

    }

    public ResponseEntity<List<ArtistDtoResponseGetAll>> getBySearch(String name) {

        ResponseEntity<List<ArtistDtoResponseGetAll>>  response;
        List<Artist> artistList;
        List<ArtistDtoResponseGetAll> artistDTOList = new ArrayList<>();
        try {

            artistList = artistRepository.findBySpecificName(name);

            for (Artist a : artistList) {
                artistDTOList.add(ArtistDtoResponseGetAll.artistToArtistDTO(a));
            }

            response = ResponseEntity.ok().body(artistDTOList);

        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body(null);
        }

        return response;

    }

    public ResponseEntity<List<ArtistDtoResponseGetAll>>  divideGet(String name) {
        if (name == null) {
            return getAll();
        } else {
            return getBySearch(name);
        }
    }
    public ResponseEntity<List<ArtistDtoResponseGetAll>>  getAll() {
        ResponseEntity<List<ArtistDtoResponseGetAll>> response;
        List<ArtistDtoResponseGetAll> songList = new ArrayList<>();
        try {
            for (Artist a : artistRepository.findAll()) {
                songList.add(ArtistDtoResponseGetAll.artistToArtistDTO(a));
            }
            response = ResponseEntity.ok().body(songList);
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body(null);
        }
        return response;

    }
}
