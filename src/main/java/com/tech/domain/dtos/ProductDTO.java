package com.tech.domain.dtos;

import java.math.BigDecimal;

import com.tech.persistence.model.ProductCategory;


public record ProductDTO(
    String name,
    BigDecimal price,
    int stock,
    ProductCategory category,
    String description,
    String imageUrl
) {} 