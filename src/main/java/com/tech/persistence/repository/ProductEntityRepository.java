package com.tech.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.domain.exceptions.NotFoundException;
import com.tech.domain.repository.ProductsRepository;
import com.tech.persistence.cruds.ProductsCRUD;
import com.tech.persistence.mappers.ProductMapper;
import com.tech.persistence.model.Product;
import com.tech.persistence.model.ProductCategory;

@Repository
public class ProductEntityRepository implements ProductsRepository {

    private final ProductsCRUD productsCRUD;
    private final ProductMapper productMapper;

    public ProductEntityRepository(ProductsCRUD productsCRUD, ProductMapper productMapper) {
        this.productsCRUD = productsCRUD;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        var products = productsCRUD.findAll();
        return productMapper.toDtos(products);  
    }

    @Override
    public ProductDTO getProductById(Long id) {
        var product = productsCRUD.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategory category) {
       var pfound = productsCRUD.findByCategory(category);
       return productMapper.toDtos(pfound);
    }

    @Override
    public List<ProductDTO> searchProducts(String query) {
        var pfound = productsCRUD.findByNameContainingIgnoreCase(query);
        return productMapper.toDtos(pfound);
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        var product2save= productMapper.toEntity(product);
        Product savedProduct = productsCRUD.save(product2save);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(long id, UpdateDTO updateDTO) {
        Product product = productsCRUD.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        productMapper.updateEntityFromDTO(updateDTO, product);
        Product updatedProduct = productsCRUD.save(product);
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        if(!productsCRUD.existsById(id)){
            throw new NotFoundException("Product not found");
        }
        productsCRUD.deleteById(id);
    }
    
}
