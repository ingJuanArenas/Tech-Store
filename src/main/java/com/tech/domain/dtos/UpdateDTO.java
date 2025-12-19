package com.tech.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDTO(
    @NotBlank(message = "la descripción no puede estar vacio")
    @Schema(description = "The description of the product", example = "Laptop Asus con procesador Intel i7, 16GB RAM y tarjeta gráfica NVIDIA RTX 3060")
    String description,
    @NotBlank(message = "la URL de la imagen no puede estar vacia")
    @Schema(description = "The image URL of the product", example = "https://example.com/images/laptop-asus.jpg")
    String imageUrl,
    @NotNull(message = "El stock no puede estar vacio ")
    @Min(value = 1, message = "el valor minimo del stock es 1") 
    @Schema(description = "The stock of the product", example = "10")
    int stock,
    @NotBlank(message = "el precio no puede estar vacia")
    @Schema(description = "The price of the product", example = "1000.00")
    String price
) {}
 
