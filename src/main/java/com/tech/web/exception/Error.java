package com.tech.web.exception;

public record Error(
    String type, 
    String message,
    String classEx

) {
} 
