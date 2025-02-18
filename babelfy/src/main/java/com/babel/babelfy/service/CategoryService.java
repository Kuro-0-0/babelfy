package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.CategoryDtoResponseList;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.repository.CategoryRepository;

@Service
public class CategoryService {

@Autowired
 private CategoryRepository repositorio;


public List<CategoryDtoResponseList> listAll (){
    List<CategoryDtoResponseList> list = new ArrayList<>();
    for(Category c : repositorio.findAll()){
        list.add(
            CategoryDtoResponseList.categoryToCategoryDTO(c)
        );
    }
    return list;
}

public void addCategory (Category c){
    repositorio.save(c);
}

}
