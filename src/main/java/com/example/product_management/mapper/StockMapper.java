package com.example.product_management.mapper;

import com.example.product_management.dto.response.StockResponseDTO;
import com.example.product_management.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "warehouseId", source = "warehouse.id")
    StockResponseDTO toResponse(Stock stock);
}
