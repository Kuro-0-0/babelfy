package com.babel.babelfy.repository;

import com.babel.babelfy.model.Song;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByName(String name);

    @Query(value = "select s from Song s where s.name like %:name%")
    List<Song> findBySpecificName(String name);
}
