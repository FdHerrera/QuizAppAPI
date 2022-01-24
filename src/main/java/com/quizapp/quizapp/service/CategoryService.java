package com.quizapp.quizapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizapp.quizapp.dto.response.CategoryResponse;
import com.quizapp.quizapp.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepo categoryRepo;
    private ObjectMapper mapper;

    public List<CategoryResponse> getCategories(){
        return categoryRepo.findAll().stream()
                .map(category -> mapper.convertValue(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }

}
