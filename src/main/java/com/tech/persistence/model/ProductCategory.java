package com.tech.persistence.model;

import java.util.Arrays;

public enum ProductCategory {
    COMPUTERS,
    SMARTPHONES,
    ACCESSORIES;

    public static ProductCategory fromString(String value) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoría inválida: " + value));
    }


    

}
