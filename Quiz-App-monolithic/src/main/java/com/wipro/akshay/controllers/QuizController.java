package com.wipro.akshay.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.akshay.entities.QuestionWrapper;
import com.wipro.akshay.entities.Quiz;
import com.wipro.akshay.entities.Response;
import com.wipro.akshay.enums.Category;
import com.wipro.akshay.enums.DifficultyLevel;
import com.wipro.akshay.services.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public Quiz createQuiz(
            @RequestParam Category category,
            @RequestParam DifficultyLevel difficulty,
            @RequestParam String title) {
        return quizService.createQuiz(category, difficulty, title);
    }

    @GetMapping("/getQuizByID/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
