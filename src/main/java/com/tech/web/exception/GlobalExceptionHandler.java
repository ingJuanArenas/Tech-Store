package com.tech.web.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.domain.exceptions.ProductAlreadyExistsException;
import com.tech.domain.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ProductNotFoundException.class)
    public Error handleProductNotFoundException(ProductNotFoundException ex){
        return new Error("Product Not Found", ex.getMessage());
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public Error handleProductAlreadyExistsException(ProductAlreadyExistsException ex){
        return new Error("Product Already Exists", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Error handleGenericException(Exception ex){
        return new Error("Internal Server Error", ex.getMessage());
    }
}
