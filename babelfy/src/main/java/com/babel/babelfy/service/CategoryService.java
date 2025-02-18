package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.dto.category.CategoryDTORequestCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.repository.CategoryRepository;


@Service
@RequiredArgsConstructor
public class CategoryService {


 private final CategoryRepository categoryRepository;


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
        try {
            List<Category> c = categoryRepository.findByName(cDTO.getName());
            if (c.isEmpty()) {
                newCategory = CategoryDTORequestCreate.categoryDTOToCategory(cDTO);
                categoryRepository.save(newCategory);
                response = ResponseEntity.ok("Category " + cDTO.getName() + " created.");
            } else {
                response = ResponseEntity.badRequest().body("You cant create this category because there is another one created with that name.");
            }
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body("Something went wrong while creating the category");
        }
        return response;
    }
}
