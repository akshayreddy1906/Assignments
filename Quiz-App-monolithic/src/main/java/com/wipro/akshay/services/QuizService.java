package com.wipro.akshay.services;

import java.util.List;

import com.wipro.akshay.entities.QuestionWrapper;
import com.wipro.akshay.entities.Quiz;
import com.wipro.akshay.entities.Response;
import com.wipro.akshay.enums.Category;
import com.wipro.akshay.enums.DifficultyLevel;

public interface QuizService {
		Quiz createQuiz(Category category, DifficultyLevel difficulty, String title);
	    
		int calculateResult(int id, List<Response> responses);

		List<QuestionWrapper> getQuizQuestions(Integer id);
}
