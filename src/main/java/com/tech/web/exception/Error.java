package com.tech.web.exception;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The error object", example = "error")
public record Error(
    String type, 
    String message,
    String classEx

) {
} 
