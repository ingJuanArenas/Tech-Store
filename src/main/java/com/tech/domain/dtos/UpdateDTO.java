package com.tech.domain.dtos;

public record UpdateDTO(
    //price, stock, description, imageUrl only updatable
    String description,
    String imageUrl, 
    int stock, 
    String price
) {}
 
