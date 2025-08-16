package com.wipro.akshay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wipro.akshay.exceptions.DonorNotFoundException;


@RestControllerAdvice 
public class GlobalExceptionHandler {
	
@ExceptionHandler(DonorNotFoundException.class)
public ResponseEntity<ErrorMessage> handleUserNotFoundException(DonorNotFoundException ex)
{
	ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),"DonorNotFoundException");
	return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
}



