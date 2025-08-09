package com.wipro.akshay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.akshay.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
