package com.wipro.akshay.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.akshay.entities.Question;
import com.wipro.akshay.services.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/quiz")
@RestController
@RequiredArgsConstructor
public class QuestionController {
	private final QuestionService questionService;
	
	@PostMapping("/addNewQuestion")
	public Question addquestion(@Valid @RequestBody Question question) {
		Question newQuestion = questionService.save( question);
		return newQuestion;
	}
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions() {
		return questionService.findAllQuestions();
	}
	@GetMapping("/getAllQuestionsPage")
	public Page<Question> getAllQuestions(Pageable pageable) {
	        
	        return questionService.findAllQuestionsPage(pageable);
	}
	
	@PatchMapping("/updateQuestionById/{id}")
	public Question updateQuestionById(@PathVariable Long id, @RequestBody Question question) {
		return questionService.updateQuestionById(id,question);
		
	}
	@DeleteMapping("/deleteQuestionById/{id}")
	public String  deleteQuestionById(@PathVariable Long id) {
	    questionService.deleteQuestionById(id); 
	    return "deleted question with id: "+ id;
	}

}
