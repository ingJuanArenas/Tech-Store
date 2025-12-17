package com.tech.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.domain.exceptions.ProductNotFoundException;
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
    public List<ProductDTO> getAllCars() {
        List<Product> products = (List<Product>) productsCRUD.findAll();
        return productMapper.toDtos(products);  
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productsCRUD.findById(id).orElseThrow(() -> new ProductNotFoundException());
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategory category) {
       List<Product> products = productsCRUD.findByCategory(category);
       return productMapper.toDtos(products);
    }

    @Override
    public List<ProductDTO> searchProducts(String query) {
        List<Product> products = productsCRUD.findByNameContainingIgnoreCase(query);
        if (products.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return productMapper.toDtos(products);
    }

    @Override
    public ProductDTO createProduct(Product Product) {
        Product savedProduct = productsCRUD.save(Product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(long id, UpdateDTO updateDTO) {
        Product product = productsCRUD.findById(id).orElseThrow(() -> new ProductNotFoundException());
        productMapper.updateEntityFromDTO(updateDTO, product);
        Product updatedProduct = productsCRUD.save(product);
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        if(!productsCRUD.existsById(id)){
            throw new ProductNotFoundException();
        }
        productsCRUD.deleteById(id);
    }
    
}
