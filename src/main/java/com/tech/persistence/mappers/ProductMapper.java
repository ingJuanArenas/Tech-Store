package com.tech.persistence.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.tech.domain.dtos.ProductDTO;
import com.tech.domain.dtos.UpdateDTO;
import com.tech.persistence.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", expression = "java(ProductCategory.fromString(productDTO.category()))")
    Product toEntity(ProductDTO productDTO);


    ProductDTO toDTO(Product product);
    List<ProductDTO> toDtos(List<Product> products);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDTO(UpdateDTO productDTO, @MappingTarget Product product);
    
} 