package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.category.*;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;


import com.babel.babelfy.dto.category.CategoryDtoRequestUpdate;
import com.babel.babelfy.dto.category.CategoryDtoRequestCreate;
import com.babel.babelfy.dto.category.CategoryDtoResponseDetails;
import com.babel.babelfy.dto.category.CategoryDtoResponseGetIDName;
import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDtoResponseList> listAll() {
        return categoryService.listAll();
    }

    @GetMapping("/{id}")
    public CategoryDtoResponseDetails show(@PathVariable long id) {
        return categoryService.showDetails(id);
    }
    
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody CategoryDtoRequestCreate cDTO) {
        return categoryService.add(cDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return categoryService.delete(id);
    }

    @PutMapping("")
    public String change(@RequestBody CategoryDtoRequestUpdate request){
        return categoryService.change(request);
    }

    @GetMapping("/names")
    public ResponseEntity<List<CategoryDtoResponseGetIDName>> getIDName() {
        return categoryService.getIDName();
    }
}
