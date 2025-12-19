package com.tech.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.domain.service.ProductService;
import com.tech.persistence.model.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "API for managing products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponse(responseCode = "200", description = "List of products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Returns a product by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)})
    @Parameter(name = "id", description = "The ID of the product", example = "1")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get products by category", description = "Returns a list of products by their category")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "List of products"),
        @ApiResponse(responseCode = "400", description = "Invalid category", content = @Content)
    })
    @Parameter(name = "category", description = "The category of the products", example = "smartphones")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/search/{query}")
    @Operation(summary = "Search products by name", description = "Returns a list of products by their name")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "List of products"),
        @ApiResponse(responseCode = "404", description = "No products found", content = @Content)
    })
    @Parameter(name = "query", description = "The query to search for", example = "asus")
    public ResponseEntity<List<ProductDTO>> searchProducts(@PathVariable String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Creates a new product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product created"),
        @ApiResponse(responseCode = "400", description = "Invalid product data", content = @Content)
    })
    @Parameter(name = "product", description = "The product to create", example = "product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Updates a product by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product updated"),
        @ApiResponse(responseCode = "400", description = "Invalid product data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @Parameter(name = "id", description = "The ID of the product", example = "1")
    @Parameter(name = "productDTO", description = "The product to update", example = "productDTO")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateDTO productDTO){
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Deletes a product by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Product deleted"),
        @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @Parameter(name = "id", description = "The ID of the product", example = "1")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
}
