package com.babel.babelfy.repository;

import com.babel.babelfy.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByName(String name);


}
