package com.tech.domain.dtos;


public record ProductDTO(
    String name,
    String description,
    String imageUrl,
    int stock,
    String category,
    String price
) {
} 