package com.example.product_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WarehouseRequestDTO {
    @NotBlank
    private String name;

    private String location;
}
