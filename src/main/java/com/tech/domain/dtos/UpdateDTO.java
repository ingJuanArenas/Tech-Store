package com.tech.domain.dtos;

public record UpdateDTO(
    String description,
    String imageUrl, 
    int stock, 
    String price
) {}
 
