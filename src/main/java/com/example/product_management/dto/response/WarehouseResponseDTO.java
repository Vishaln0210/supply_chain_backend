package com.example.product_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseResponseDTO {
    private Long id;
    private String name;
    private String location;
}
