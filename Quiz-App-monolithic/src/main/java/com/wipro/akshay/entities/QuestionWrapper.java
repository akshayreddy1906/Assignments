package com.wipro.akshay.entities;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    
    private Long id;
    private String questionTitle;
    private List<String> options;
}
