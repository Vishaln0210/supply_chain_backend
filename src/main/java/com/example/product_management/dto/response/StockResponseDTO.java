package com.example.product_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockResponseDTO {

    private Long id;
    private Long productId;
    private Long warehouseId;
    private Integer quantity;
}
