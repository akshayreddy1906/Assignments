package com.wipro.akshay.entities;

import java.util.List;

import com.wipro.akshay.enums.Category;
import com.wipro.akshay.enums.DifficultyLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "question should not be empty")
	private String questionTitle;
	
	@Size(min= 4, max=4)
	@NotEmpty(message = "options should not be empty")
	private List<String> options;

	@NotBlank(message = "question should not be empty")
	private String CorrectAnswer;
	

	@NotNull(message = "difficulty level is required")
	private DifficultyLevel difficulty;
	
	@NotNull(message = "category is required" )
	private Category category;
	
}
