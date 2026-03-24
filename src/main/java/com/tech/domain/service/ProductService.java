package com.tech.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.domain.exceptions.NotFoundException;
import com.tech.domain.repository.ProductsRepository;
import com.tech.persistence.model.ProductCategory;


@Service
public class ProductService {
    private final ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductDTO> getAllProducts() {
        var products = productsRepository.getAllProducts();
        if (products.isEmpty()) throw new NotFoundException("No contents found");
        return products ;
    }

    public ProductDTO getProductById(Long id) {
        return productsRepository.getProductById(id);
    }
    public List<ProductDTO> getProductsByCategory(ProductCategory category) {
        var pfound = productsRepository.getProductsByCategory(category);
        if (pfound.isEmpty()) throw new NotFoundException("No contents found");
        return pfound;
    }

    public List<ProductDTO> searchProducts(String query) {
        var pfound= productsRepository.searchProducts(query);
        if (pfound.isEmpty()) throw new NotFoundException("No contents found");        
        return pfound;
    }

    public ProductDTO createProduct(ProductDTO product){
        return productsRepository.createProduct(product);
    }

    public ProductDTO updateProduct(long id, UpdateDTO updateDTO) {
        return productsRepository.updateProduct(id, updateDTO);
    }

    public void deleteProduct(long id) {
        productsRepository.deleteProduct(id);
    }
}



