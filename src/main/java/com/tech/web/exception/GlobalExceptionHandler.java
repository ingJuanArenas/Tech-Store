package com.tech.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.tech.domain.exceptions.AlreadyExistsException;
import com.tech.domain.exceptions.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> handleProductNotFoundException(NotFoundException ex){
        return ResponseEntity.status(404).body(new Error("Product Not Found", ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Error> handleProductAlreadyExistsException(AlreadyExistsException ex){
        return ResponseEntity.status(409).body(new Error("Product Already Exists", ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException ex){
        return ResponseEntity.status(400).body(new Error("Bad Request", ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.status(400).body(new Error("Bad Request", ex.getMessage(), ex.toString()));
    }
    
        @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return ResponseEntity.status(400).body(new Error("Bad Request", ex.getMessage(), ex.toString()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex){
        return ResponseEntity.status(500).body(new Error("Internal Server Error", ex.getMessage(), ex.toString()));
    }
}
