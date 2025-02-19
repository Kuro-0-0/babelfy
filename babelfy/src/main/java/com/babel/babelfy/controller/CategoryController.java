package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.category.CategoryDTORequestCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.dto.category.CategoryDtoResponseDetails;
import com.babel.babelfy.service.CategoryService;

@RequestMapping("/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody CategoryDTORequestCreate cDTO) {
        return categoryService.add(cDTO);
    }

    //Para crear siempre es con el request body
    //con un id el pathvariable
    //requestparam para filtros
    @GetMapping("")
    public List<CategoryDtoResponseList> listAll() {
        return categoryService.listAll();
    }

    @GetMapping("/{id}")
    public CategoryDtoResponseDetails show(@PathVariable long id) {
        return categoryService.showDetails(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){return categoryService.delete(id);}
}
