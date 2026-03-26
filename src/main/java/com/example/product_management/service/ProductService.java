package com.example.product_management.service;

import com.example.product_management.dto.request.ProductRequestDTO;
import com.example.product_management.dto.response.ProductResponseDTO;
import com.example.product_management.dto.response.SupplierResponseDTO;
import com.example.product_management.model.Product;
import com.example.product_management.model.Supplier;
import com.example.product_management.exception.*;
import com.example.product_management.mapper.ProductMapper;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductResponseDTO create(ProductRequestDTO dto) {
        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setSupplier(supplier);

        return mapToResponse(productRepository.save(product));
    }

    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ProductResponseDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToResponse(product);
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setSupplier(supplier);

        return mapToResponse(productRepository.save(product));
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }

    private ProductResponseDTO mapToResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new SupplierResponseDTO(
                        product.getSupplier().getId(),
                        product.getSupplier().getName()
                )
        );
    }
}