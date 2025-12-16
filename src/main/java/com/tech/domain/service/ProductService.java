package com.tech.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.domain.repository.ProductsRepository;
import com.tech.persistence.model.Product;


@Service
public class ProductService {
    private final ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productsRepository.getAllCars();
    }

    public ProductDTO getProductById(Long id) {
        return productsRepository.getProductById(id);
    }
    public List<ProductDTO> getProductsByCategory(String category) {
        return productsRepository.getProductsByCategory(category);
    }

    public List<ProductDTO> searchProducts(String query) {
        return productsRepository.searchProducts(query);
    }

    public ProductDTO createProduct(Product product){
        return productsRepository.createProduct(product);
    }

    public ProductDTO updateProduct(long id, UpdateDTO updateDTO) {
        return productsRepository.updateProduct(id, updateDTO);
    }

    public void deleteProduct(long id) {
        productsRepository.deleteProduct(id);
    }
}



