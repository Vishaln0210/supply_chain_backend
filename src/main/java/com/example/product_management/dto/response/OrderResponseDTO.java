package com.example.product_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponseDTO {

    private Long id;
    private String status;
    private List<OrderItemResponseDTO> items;
}
