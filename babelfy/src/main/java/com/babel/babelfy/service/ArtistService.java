package com.babel.babelfy.service;

import com.babel.babelfy.dto.artist.*;
import com.babel.babelfy.model.Artist;
import com.babel.babelfy.repository.ArtistRepository;

import jakarta.transaction.Transactional;
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

    @Transactional
    public ArtistDtoResponseDetails showDetails(long id) {
        Artist c = artistRepository.findById(id).orElse(null);
        return ArtistDtoResponseDetails.artistToArtistDTO(c);
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

    @Transactional
    public String delete(long id) {
        Artist a = artistRepository.findById(id).orElse(null);
        String response = "";
        if (a != null) {

            for (int i = 0; i < a.getSongList().size(); i++) {
                if(a.getSongList().get(i).getArtists().size()>1){
                    response = "This artist cannot be deleted because it has at least one song with another artist. You have to delete these songs to be able to delete this artist";
                }else{
                    artistRepository.delete(a);
                response = "This artist was successfully deleted ";
                }
            }
            
        } else {
            response = "There is not an artist with such id";
        }
        return response;
    }

    public ResponseEntity<String> modify(ArtistDtoRequestUpdate request) {
        ResponseEntity<String> response;
        Artist a = ArtistDtoRequestUpdate.artistDTOToArtist(request);
        Artist old = artistRepository.findById(a.getId()).orElse(null);
        List<Artist> list = artistRepository.findByName(a.getName());
        try {
            if (old != null) {
                if (list.isEmpty() || old.getName().equals(a.getName())) {
                        a.setColor(old.getColor());
                        artistRepository.save(a);
                        response = ResponseEntity.ok().body("Changes made successfully");
                } else {
                    response = ResponseEntity.badRequest().body("You can't make this change because this name is already in use");
                }
            } else {
                response = ResponseEntity.badRequest().body("You can't make this change because this Artist does not exist");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body("Something went wrong while updating the artist.");
        }
        return response;

    }

    public ResponseEntity<List<ArtistDtoResponseGetIDName>> getIDName() {
        ResponseEntity<List<ArtistDtoResponseGetIDName>> response;
        List<ArtistDtoResponseGetIDName> artistDtoResponseGetIDNameList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        try {

            artistList = artistRepository.findAll();
            if (!artistList.isEmpty()) {
                for (Artist a : artistList) {
                    artistDtoResponseGetIDNameList.add(ArtistDtoResponseGetIDName.artistToArtistDTO(a));
                }
                response = ResponseEntity.ok().body(artistDtoResponseGetIDNameList);
            } else {
                response = ResponseEntity.badRequest().body(null);
            }

        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body(null);
        }
        return response;
    }
}
