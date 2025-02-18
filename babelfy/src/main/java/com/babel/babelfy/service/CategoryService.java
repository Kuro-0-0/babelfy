package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.babel.babelfy.dto.category.CategoryDTORequestCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.repository.CategoryRepository;

@Service
public class CategoryService {

@Autowired
 private CategoryRepository categoryRepository;


public List<CategoryDtoResponseList> listAll (){
    List<CategoryDtoResponseList> list = new ArrayList<>();
    for(Category c : categoryRepository.findAll()){
        list.add(
            CategoryDtoResponseList.categoryToCategoryDTO(c)
        );
    }
    return list;
}


    public ResponseEntity<String> add(CategoryDTORequestCreate cDTO) {
        ResponseEntity<String> response;
        Category newCategory;
        boolean encontrado = false;
        try {
            Optional<List<Category>> c = categoryRepository.findByName(cDTO.getName());
            if (c.isEmpty()) {
                newCategory = CategoryDTORequestCreate.categoryDTOToCategory(cDTO);
                categoryRepository.save(newCategory);
                response = ResponseEntity.ok("Category " + cDTO.getName() + " created.");
            } else {
                response = ResponseEntity.badRequest().body("You cant create this category because there is another one created with that name.");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body("Something went wrong while creating the category");
        }
        return response;
    }
}
