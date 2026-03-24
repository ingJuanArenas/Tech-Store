package com.tech.persistence.cruds;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.persistence.model.Product;
import com.tech.persistence.model.ProductCategory;

public interface ProductsCRUD extends JpaRepository<Product,Long> {
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByNameContainingIgnoreCase(String name);
}