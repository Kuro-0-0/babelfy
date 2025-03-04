package com.babel.babelfy.repository;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByName(String name);

    @Query(value = "select a from Artist a where a.name like %:name%")
    List<Artist> findBySpecificName(String name);


}
