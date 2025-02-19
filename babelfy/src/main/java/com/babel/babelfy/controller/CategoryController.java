package com.babel.babelfy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babel.babelfy.dto.CategoryDtoRequestChange;
import com.babel.babelfy.dto.CategoryDtoResponseDetails;
import com.babel.babelfy.dto.CategoryDtoResponseList;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.service.CategoryService;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;


//EXAMPLE TO TRY THE LIST METHOD
@PostMapping("")
public String annadir(){
    Category c=new Category("das", 3);
    service.addCategory(c);
    return "Funcionando";
}
//Para crear siempre es con el request body
//con un id el pathvariable
//requestparam para filtros
@GetMapping("")
    public List<CategoryDtoResponseList> listAll (){
        return service.listAll();
    }

@GetMapping("/{id}")
    public CategoryDtoResponseDetails show(@PathVariable long id){
        return service.showDetails(id);
    }

@PutMapping("")
    public String change(@RequestBody CategoryDtoRequestChange request){
        return service.change(request);
    }
}
