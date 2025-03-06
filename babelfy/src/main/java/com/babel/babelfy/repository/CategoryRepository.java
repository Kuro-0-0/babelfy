package com.babel.babelfy.repository;

import com.babel.babelfy.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

    @Query(value = "select c from Category c where c.name like %:name%")
    List<Category> findBySpecificName(String name);

}
