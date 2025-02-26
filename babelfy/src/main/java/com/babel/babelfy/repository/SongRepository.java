package com.babel.babelfy.repository;

import com.babel.babelfy.model.Song;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByName(String name);

     List<Song> findByArtistName(String artistName);
 }
