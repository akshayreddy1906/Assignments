package com.wipro.akshay.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.akshay.entities.Question;

public interface QuestionService {

	Question save(Question question);

	List<Question> findAllQuestions();

	Question updateQuestionById(Long id, Question question);

	void deleteQuestionById(Long id);

	Page<Question> findAllQuestionsPage(Pageable pageable);

}
