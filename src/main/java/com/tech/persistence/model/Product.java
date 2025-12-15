package com.tech.persistence.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private ProductCategory category;

    @Column(length = 2000)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public ProductCategory getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    


}
