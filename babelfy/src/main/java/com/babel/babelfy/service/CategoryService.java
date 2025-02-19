package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.CategoryDtoRequestChange;
import com.babel.babelfy.dto.CategoryDtoResponseDetails;
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

public CategoryDtoResponseDetails showDetails(long id){
    Category c=repositorio.findById(id).orElseThrow(null);
    return CategoryDtoResponseDetails.categoryToCategoryDTO(c);
}

public void addCategory (Category c){
    repositorio.save(c);
}

public String change(CategoryDtoRequestChange request){
    String response;
    Category c=CategoryDtoRequestChange.categoryDTOToCategory(request);
    Category old=repositorio.findById(c.getId()).orElse(null);
    List<Category> list= repositorio.findByName(c.getName());
    System.out.println(request);
    if(list.isEmpty()&&old!=null){
        repositorio.save(c);
        response="Changes made successfully.";
    }else{
        response="Chansrhsrhsrhsrhrhlly.";

    } 
    return response;
    }
    
}


