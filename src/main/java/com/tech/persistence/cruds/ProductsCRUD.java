package com.tech.persistence.cruds;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tech.persistence.model.Product;

public interface ProductsCRUD extends CrudRepository<Product,Long> {
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findByNameContainingIgnoreCase(String name);
}