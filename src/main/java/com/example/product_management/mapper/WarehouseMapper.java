package com.example.product_management.mapper;

import com.example.product_management.dto.request.WarehouseRequestDTO;
import com.example.product_management.dto.response.WarehouseResponseDTO;
import com.example.product_management.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    @Mapping(target = "id", ignore = true)
    Warehouse toEntity(WarehouseRequestDTO dto);

    WarehouseResponseDTO toResponse(Warehouse entity);
}
