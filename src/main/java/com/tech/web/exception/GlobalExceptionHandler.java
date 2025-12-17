package com.tech.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.domain.exceptions.ProductAlreadyExistsException;
import com.tech.domain.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Error> handleProductNotFoundException(ProductNotFoundException ex){
        return ResponseEntity.status(404).body(new Error("Product Not Found", ex.getMessage()));
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Error> handleProductAlreadyExistsException(ProductAlreadyExistsException ex){
        return ResponseEntity.status(409).body(new Error("Product Already Exists", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException ex){
        return ResponseEntity.status(400).body(new Error("Bad Request", ex.getMessage()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex){
        return ResponseEntity.status(500).body(new Error("Internal Server Error", ex.getMessage()));
    }
}
