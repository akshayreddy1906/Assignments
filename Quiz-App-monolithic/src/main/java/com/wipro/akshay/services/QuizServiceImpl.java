package com.wipro.akshay.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wipro.akshay.entities.Question;
import com.wipro.akshay.entities.QuestionWrapper;
import com.wipro.akshay.entities.Quiz;
import com.wipro.akshay.entities.Response;
import com.wipro.akshay.enums.Category;
import com.wipro.akshay.enums.DifficultyLevel;
import com.wipro.akshay.exceptions.QUESTION_NOT_FOUND_EXCEPTION;
import com.wipro.akshay.repositories.QuestionRepository;
import com.wipro.akshay.repositories.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private static final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    
    @Override
    public Quiz createQuiz(Category category, DifficultyLevel difficulty, String title) {
        log.info("Creating quiz: category={}, difficulty={}, title={}", category, difficulty, title);

        List<Question> questions = questionRepository
                .findRandomQuestionsByCategeryAndLevel(category.toString(), difficulty.toString());

        if (questions.isEmpty()) {
            log.warn("No questions found for category={}, difficulty={}", category, difficulty);
            throw new QUESTION_NOT_FOUND_EXCEPTION(
                    "No questions available for category " + category + " and difficulty " + difficulty);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        return quizRepository.save(quiz);
    }


    public Quiz getQuiz(int id) {
        return quizRepository.findById((long) id)
                .orElseThrow(() -> new QUESTION_NOT_FOUND_EXCEPTION("Quiz not found with id " + id));
    }



    public List<Question> getQuestions(int id) {
        Quiz quiz = getQuiz(id);               
        return quiz.getQuestions();
    }

    @Override
    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        return getQuestions(id).stream()
                .map(q -> new QuestionWrapper(
                        q.getId(),
                        q.getQuestionTitle(),
                        q.getOptions()))
                .collect(Collectors.toList());
    }


    @Override
    public int calculateResult(int id, List<Response> responses) {
        Quiz quiz = getQuiz(id);
        List<Question> questions = quiz.getQuestions();


        int correct = 0;
        for (Response r : responses) {
        	  boolean isCorrect = questions.stream()
        		        .anyMatch(q -> 
        		            q.getId() == r.getId() && 
        		            q.getCorrectAnswer().equalsIgnoreCase(r.getResponse()));
            if (isCorrect) {
                correct++; }
        }

        log.info("Quiz id={} scored {}/{}", id, correct, questions.size());
        return correct;
    }
}