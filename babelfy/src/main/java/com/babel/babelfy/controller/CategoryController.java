package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.category.CategoryDTORequestCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.babel.babelfy.dto.category.CategoryDtoResponseList;
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

}
