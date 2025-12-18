package com.tech.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
    @NotBlank(message = "El nombre no puede estar vacio")
    String name,
    @NotBlank(message = "La descripción no puede estar vacia")
    String description,
    @NotBlank(message = "La URL de la imagen no puede estar vacia")
    String imageUrl,
    @NotNull(message = "El stock no puede estar vacio ")
    @Min(value = 1, message = "El valor minimo es 1")
    int stock,
    @NotBlank(message = "La Categoría no puede estar vacia")
    String category,
    @NotNull(message = "El precio no puede estar vacio")
    String price
) {
} 