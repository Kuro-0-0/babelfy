package com.babel.babelfy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.babel.babelfy.model.Song;
import com.babel.babelfy.repository.SongRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.babel.babelfy.model.Category;
import com.babel.babelfy.repository.CategoryRepository;

import jakarta.transaction.Transactional;

import com.babel.babelfy.dto.category.CategoryDtoRequestCreate;
import com.babel.babelfy.dto.category.CategoryDtoResponseDetails;
import com.babel.babelfy.dto.category.CategoryDtoResponseGetIDName;
import com.babel.babelfy.dto.category.CategoryDtoResponseList;
import com.babel.babelfy.dto.song.SongDtoResponseGetAll;
import com.babel.babelfy.dto.category.CategoryDtoRequestUpdate;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SongRepository songRepository;


    public List<CategoryDtoResponseList> listAll() {
        List<CategoryDtoResponseList> list = new ArrayList<>();

        for (Category c : categoryRepository.findAll()) {
            list.add(
                    CategoryDtoResponseList.categoryToCategoryDTO(c)
            );
        }

        return list;
    }

    public List<CategoryDtoResponseList> getBySearch(String name){

        List<Category> categoryList;
        List<CategoryDtoResponseList> CategoryDTOList = new ArrayList<>();

            categoryList = categoryRepository.findBySpecificName(name);

            for (Category c : categoryList) {
                CategoryDTOList.add(CategoryDtoResponseList.categoryToCategoryDTO(c));
            }

        return CategoryDTOList;
    }

    public List<CategoryDtoResponseList> divideGet(String name){
        if (name == null) {
            return listAll();
        } else {
            return getBySearch(name);
        }
    }

    @Transactional
    public CategoryDtoResponseDetails showDetails(long id) {
        Category c = categoryRepository.findById(id).orElse(null);
        return CategoryDtoResponseDetails.categoryToCategoryDTO(c);
    }

    public ResponseEntity<String> add(CategoryDtoRequestCreate cDTO) {
        ResponseEntity<String> response;
        Category newCategory;

        try {
            List<Category> c = categoryRepository.findByName(cDTO.getName());
            if (c.isEmpty()) {
                newCategory = CategoryDtoRequestCreate.categoryDtoToCategory(cDTO);
                String values[]= {"A","B","C","D","E","F","0","1","2","3","4","5","6","7","8","9"};
                String color="";
                Random rnd = new Random();
                
                for (int i = 0; i < 6; i++) {
                    color=color+values[rnd.nextInt(values.length-1)+1];
                }
                newCategory.setColor(color);
                categoryRepository.save(newCategory);
                response = ResponseEntity.ok("Category " + cDTO.getName() + " created.");
            } else {
                response = ResponseEntity.badRequest().body
                ("You can't create this category because there is already one with that name.");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body
            ("Something went wrong while creating the category");
        }

        return response;
    }

    public String change(CategoryDtoRequestUpdate request){
        String response;
        Category c=CategoryDtoRequestUpdate.categoryDTOToCategory(request);
        Category old=categoryRepository.findById(c.getId()).orElse(null);
        List<Category> list= categoryRepository.findByName(c.getName());

        if(list.isEmpty()){
            if(old!=null){
                categoryRepository.save(c);
                response="Changes made successfully";
            }else{
                response="You can't make this change because this category does not exist";
            }
        } else{
            response="You can't make this change because this name is already in use";
        }

        return response;
    }

    @Transactional
    public ResponseEntity<String> delete(long id) {
        ResponseEntity<String> response;
        Category c;

        try {
            c = categoryRepository.findById(id).orElse(null);
            if (c != null) {

                for (Song s : c.getSongs()) {
                    s.setCategory(categoryRepository.findByName("None").getFirst());
                    songRepository.save(s);
                }
                categoryRepository.delete(c);
                response = ResponseEntity.ok("Category " + c.getName() + " deleted");
            } else {
                response = ResponseEntity.badRequest().body
                ("The category you are trying to delete don't exist");
            }
        }
        catch (Exception e) {
            System.out.println(e);
            response = ResponseEntity.internalServerError().body
            ("Something went wrong while deleting the category");
        }

        return response;
    }

    public ResponseEntity<List<CategoryDtoResponseGetIDName>> getIDName() {
        ResponseEntity<List<CategoryDtoResponseGetIDName>> response;
        List<CategoryDtoResponseGetIDName> categoryDtoResponseGetIDNameList = new ArrayList<CategoryDtoResponseGetIDName>();
        List<Category> categoryList = new ArrayList<Category>();
        try {

            categoryList = categoryRepository.findAll();
            if (!categoryList.isEmpty()) {
                for (Category c : categoryList) {
                    categoryDtoResponseGetIDNameList.add(CategoryDtoResponseGetIDName.categoryToCategoryDto(c));
                }
                response = ResponseEntity.ok().body(categoryDtoResponseGetIDNameList);
            } else {
                response = ResponseEntity.badRequest().body(null);
            }

        } catch (Exception e) {
            response  = ResponseEntity.internalServerError().body(null);
        }
        return response;
    }
}
