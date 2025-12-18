package com.tech.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDTO(
    @NotBlank(message = "la descripción no puede estar vacio")
    String description,
    @NotBlank(message = "la URL de la imagen no puede estar vacia")
    String imageUrl,
    @NotNull(message = "El stock no puede estar vacio ")
    @Min(value = 1, message = "el valor minimo del stock es 1") 
    int stock,
    @NotBlank(message = "el precio no puede estar vacia")
    String price
) {}
 
