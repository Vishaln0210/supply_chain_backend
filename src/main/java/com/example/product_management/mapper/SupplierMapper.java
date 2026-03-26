package com.example.product_management.mapper;

import com.example.product_management.dto.request.SupplierRequestDTO;
import com.example.product_management.dto.response.SupplierResponseDTO;
import com.example.product_management.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "products", ignore = true)

    Supplier toEntity(SupplierRequestDTO dto);

    SupplierResponseDTO toResponse(Supplier supplier);
}