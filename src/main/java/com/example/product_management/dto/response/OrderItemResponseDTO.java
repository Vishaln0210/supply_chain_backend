package com.example.product_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemResponseDTO {

    private Long productId;
    private Integer quantity;
}
