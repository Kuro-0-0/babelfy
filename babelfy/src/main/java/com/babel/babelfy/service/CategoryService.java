package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.dto.category.CategoryDTORequestCreate;
import com.babel.babelfy.dto.category.CategoryDtoResponseDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.dto.CategoryDtoRequestChange;
import com.babel.babelfy.dto.CategoryDtoResponseDetails;
import com.babel.babelfy.dto.CategoryDtoResponseList;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDtoResponseList> listAll() {
        List<CategoryDtoResponseList> list = new ArrayList<>();
        for (Category c : categoryRepository.findAll()) {
            list.add(
                    CategoryDtoResponseList.categoryToCategoryDTO(c)
            );
        }
        return list;
    }

    public CategoryDtoResponseDetails showDetails(long id) {
        Category c = categoryRepository.findById(id).orElseThrow(null);
        return CategoryDtoResponseDetails.categoryToCategoryDTO(c);
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


