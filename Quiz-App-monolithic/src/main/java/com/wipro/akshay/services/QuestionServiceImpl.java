package com.wipro.akshay.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.akshay.entities.Question;
import com.wipro.akshay.exceptions.QUESTION_NOT_FOUND_EXCEPTION;
import com.wipro.akshay.repositories.QuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

	private final QuestionRepository questionRepository;
	@Override
	public Question save(Question question) {
		// TODO Auto-generated method stub
		try {
            Question savedQuestion = questionRepository.save(question);
            log.warn("After saving to DB, questionTitle: {}", savedQuestion.getQuestionTitle());
            log.warn("After saving to DB, category: {}", savedQuestion.getCategory());
            log.warn("After saving to DB, correctAnswer: {}", savedQuestion.getCorrectAnswer());
            log.warn("After saving to DB, difficulty: {}", savedQuestion.getDifficulty());
            log.warn("After saving to DB, category: {}", savedQuestion.getCategory());
            return savedQuestion;
        } catch (Exception e) {
            log.error("Exception occurred: {}", e.getMessage(), e);
            throw new RuntimeException("Could not save question! " + e.getMessage());
        }
	}
	@Override
	public List<Question> findAllQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
		}
	@Override
	public Question updateQuestionById(Long id, Question questionDetails) {
		// TODO Auto-generated method stub
		Question existingQuestion = questionRepository.findById(id)
	            .orElseThrow(() -> new QUESTION_NOT_FOUND_EXCEPTION("Question not found with id " + id));

		if (questionDetails.getQuestionTitle() != null) {
		    existingQuestion.setQuestionTitle(questionDetails.getQuestionTitle());
		}
		if (questionDetails.getOptions() != null) {
		    existingQuestion.setOptions(questionDetails.getOptions());
		}
		if (questionDetails.getCorrectAnswer() != null) {
		    existingQuestion.setCorrectAnswer(questionDetails.getCorrectAnswer());
		}
		if (questionDetails.getDifficulty() != null) {
		    existingQuestion.setDifficulty(questionDetails.getDifficulty());
		}
		if (questionDetails.getCategory() != null) {
		    existingQuestion.setCategory(questionDetails.getCategory());
		}
	        return questionRepository.save(existingQuestion);
	}
	@Override
	public void deleteQuestionById(Long id) {
		// TODO Auto-generated method stub
		if (!questionRepository.existsById(id)) {
	        throw new QUESTION_NOT_FOUND_EXCEPTION("Question with id " + id + " not found.");
	    }
	    questionRepository.deleteById(id);
	}
	@Override
	public Page<Question> findAllQuestionsPage(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

}
