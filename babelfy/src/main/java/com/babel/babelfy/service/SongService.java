package com.babel.babelfy.service;

import com.babel.babelfy.dto.song.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.repository.ArtistRepository;
import com.babel.babelfy.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.model.Category;
import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository songRepository;
    private final CategoryRepository categoryRepository;
    private final ArtistRepository artistRepository;

    @Transactional
    public Song SongDtoToSong(SongDtoRequestCreate songDto) {
        Category c = categoryRepository.findById(songDto.getIdCategory()).orElse(null);

        List <Artist> artistList = new ArrayList<>();

        for (long i : songDto.getArtistId()) {
            Artist a;
            a = artistRepository.findById(i).orElse(null);
            if (a != null) {
                artistList.add(a);
            }
        }

        return Song.builder()
                .name(songDto.getName())
                .duration(songDto.getDuration())
                .artists(artistList)
                .albumName(songDto.getAlbumName())
                .releaseDate(songDto.getReleaseDate())
                .category(c)
                .build();
    }

    @Transactional
    public Song songDtoToSong(SongDtoRequestUpdate sDTO, Song song) {
        return Song.builder()
                .id(sDTO.getId())
                .color(song.getColor())
                .name(sDTO.getName())
                .artists(song.getArtists())
                .duration(sDTO.getDuration())
                .albumName(sDTO.getAlbumName())
                .releaseDate(sDTO.getReleaseDate())
                .category(categoryRepository.findById(sDTO.getCategoryId()).orElse(null))
                .build();
    }

    @Transactional
    public String add(SongDtoRequestCreate cDTO) {
        String response = "";
        Song newSong = SongDtoToSong(cDTO);
        List<Song> list = songRepository.findByName(newSong.getName());
        List<Artist> artistList = new ArrayList<>();
        List<Song> artistSongs = new ArrayList<>();
        boolean isHereArtist = false;
        if (list.isEmpty()) {
            String values[] = {"A", "B", "C", "D", "E", "F", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String color = "";
            Random rnd = new Random();

            for (int i = 0; i < 6; i++) {
                color = color + values[rnd.nextInt(values.length - 1) + 1];
            }
            newSong.setColor(color);
            songRepository.save(newSong);
            newSong.getCategory().getSongs().add(newSong);
            categoryRepository.save(newSong.getCategory());
            response = "This song was successfully created";
        } else {

            for (int i = 0; i < list.size(); i++) {
                artistList.addAll(list.get(i).getArtists());
            }

            for (int i = 0; i < artistList.size(); i++) {
                artistSongs.addAll(artistList.get(i).getSongList());
            }

            for (int i = 0; i < artistSongs.size() && !isHereArtist; i++) {
                if (artistSongs.get(i).getName().equalsIgnoreCase(newSong.getName())) {
                    isHereArtist = true;
                }
            }

            if (isHereArtist) {
                response = "This artist already has a song named like this";
            } else {
                songRepository.save(newSong);
                newSong.getCategory().getSongs().add(newSong);
                response = "This song was successfully created ";
            }

        }

        return response;
    }

    public String delete(long id) {
        Song s = songRepository.findById(id).orElse(null);
        System.out.println(s);
        String response = "";
        if (s != null) {
            songRepository.delete(s);
            response = "This song was successfully deleted ";
        } else {
            response = "There is not a song with such id";
        }
        return response;
    }

    @Transactional
    public ResponseEntity<SongDtoResponseDetails> getDetails(long id) {

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
            System.out.println(e);
            response = ResponseEntity.internalServerError().body(null);
        }
        return response;
    }

    @Transactional
    public ResponseEntity<String> update(SongDtoRequestUpdate sDTO) {
        ResponseEntity<String> response = ResponseEntity.internalServerError().body("Something went wrong while processing the data");
        Song modSong;
        try {
            modSong = songRepository.findById(sDTO.getId()).orElse(null);
            List<Song> artistSongs = new ArrayList<>();
            boolean find = false;
            if (modSong != null) {

                for (Artist a :modSong.getArtists()) {
                    List<Song> songs = a.getSongList();
                    artistSongs.addAll(songs);
                }

                if (!artistSongs.isEmpty()) {
                    for (Song s : artistSongs) {
                        if (!find && s.getName().equalsIgnoreCase(modSong.getName()) && s.getId() != sDTO.getId()) {
                            find = true;
                            response = ResponseEntity.badRequest().body("There is already song of that artist with that name.");
                        }
                    }

                    if (!find) {
                        modSong = songDtoToSong(sDTO, modSong);
                        songRepository.save(modSong);
                        response = ResponseEntity.ok().body("Song data updated");
                    }

                } else {
                    modSong = songDtoToSong(sDTO, modSong);
                    songRepository.save(modSong);
                    response = ResponseEntity.ok().body("Song data updated");
                }
            } else {
                response = ResponseEntity.badRequest().body("That song doesn't exist");
            }

        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body("Something went wrong on the Server side");
        }
        return response;
    }

    public ResponseEntity<String> deleteCategory(long id) {

        ResponseEntity<String> response;
        Song song;

        try {
            song = songRepository.findById(id).orElse(null);
            if (song != null) {
                song.setCategory(categoryRepository.findByName("None").getFirst());
                songRepository.save(song);
                response = ResponseEntity.ok().body("Category detachment successful");
            } else {
                response = ResponseEntity.badRequest().body("The song selected, doesnt exists.");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body("Something went wrong on the server side.");
        }

        return response;

    }

    public ResponseEntity<List<SongDtoResponseGetAll>> getBySearch(String name) {

        ResponseEntity<List<SongDtoResponseGetAll>> response;
        List<Song> songList;
        List<SongDtoResponseGetAll> songDTOList = new ArrayList<>();
        try {

            songList = songRepository.findBySpecificName(name);

            for (Song s : songList) {
                songDTOList.add(SongDtoResponseGetAll.songToSongDTO(s));
            }

            response = ResponseEntity.ok().body(songDTOList);

        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body(null);
        }

        return response;

    }

    public ResponseEntity<List<SongDtoResponseGetAll>> divideGet(String name) {
        if (name == null) {
            return getAll();
        } else {
            return getBySearch(name);
        }
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
}
