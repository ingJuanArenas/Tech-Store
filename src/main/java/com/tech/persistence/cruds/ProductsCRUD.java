package com.tech.persistence.cruds;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tech.persistence.model.Product;
import com.tech.persistence.model.ProductCategory;

public interface ProductsCRUD extends CrudRepository<Product,Long> {
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByNameContainingIgnoreCase(String name);
}