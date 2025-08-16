package com.wipro.akshay;

import com.wipro.akshay.exceptions.BloodRequestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BloodRequestNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBloodRequestNotFound(BloodRequestNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(ex.getMessage(), "BLOOD_REQUEST_NOT_FOUND");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
