package com.wipro.akshay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DonorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
 
	public DonorNotFoundException(String message) {
		super(message);
	}	
}
