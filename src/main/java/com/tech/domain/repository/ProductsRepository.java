package com.tech.domain.repository;

import java.util.List;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.persistence.model.Product;
import com.tech.persistence.model.ProductCategory;

public interface ProductsRepository {
    List<ProductDTO> getAllCars();
    ProductDTO getProductById(Long id);
    List<ProductDTO> getProductsByCategory(ProductCategory category);
    List<ProductDTO> searchProducts(String query);
    ProductDTO createProduct(Product Product);
    ProductDTO updateProduct(long id, UpdateDTO updateDTO);
    void deleteProduct(long id);

}
