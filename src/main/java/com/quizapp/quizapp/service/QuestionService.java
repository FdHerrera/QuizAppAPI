package com.quizapp.quizapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizapp.quizapp.dto.response.QuestionResponse;
import com.quizapp.quizapp.model.Category;
import com.quizapp.quizapp.model.Question;
import com.quizapp.quizapp.repository.CategoryRepo;
import com.quizapp.quizapp.repository.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepo questionRepo;
    private CategoryRepo categoryRepo;
    private ObjectMapper mapper;

    public List<QuestionResponse> getQuestionsByCategory(Long categoryId) {
        Optional<Category> categoryFound = categoryRepo.findById(categoryId);
        Optional<List<Question>> questionsFound = questionRepo.findByCategory(categoryFound.orElseThrow(IllegalAccessError::new));
        List<Question> questions = questionsFound.orElseThrow(IllegalStateException::new);
        return questions.stream()
                .map(question -> mapper.convertValue(question, QuestionResponse.class))
                .collect(Collectors.toList());
    }
}
