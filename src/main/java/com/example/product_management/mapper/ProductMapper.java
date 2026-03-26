package com.example.product_management.mapper;

import com.example.product_management.dto.request.ProductRequestDTO;
import com.example.product_management.dto.response.ProductResponseDTO;
import com.example.product_management.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    Product toEntity(ProductRequestDTO dto);
    ProductResponseDTO toResponse(Product product);
}