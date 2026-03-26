package com.example.product_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierRequestDTO {

    @NotBlank(message = "Supplier name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String contactEmail;
}
