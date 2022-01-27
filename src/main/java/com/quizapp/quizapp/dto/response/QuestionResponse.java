package com.quizapp.quizapp.dto.response;

import com.quizapp.quizapp.dto.AnswerDto;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse {
    private Long id;
    private String question;
    private List<AnswerDto> answers;
}
