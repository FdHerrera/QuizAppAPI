package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.dto.response.CategoryResponse;
import com.quizapp.quizapp.dto.response.QuestionResponse;
import com.quizapp.quizapp.service.CategoryService;
import com.quizapp.quizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:/localhost:4200")
@RequestMapping(path = "categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryResponse> response = categoryService.getCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<List<QuestionResponse>> getQuestionsByCategoryId(@PathVariable("categoryId") Long categoryId){
        List<QuestionResponse> response = questionService.getQuestionsByCategory(categoryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
