package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.dto.response.CategoryResponse;
import com.quizapp.quizapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryResponse> response = categoryService.getCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
