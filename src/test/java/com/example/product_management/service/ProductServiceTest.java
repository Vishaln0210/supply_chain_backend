package com.example.product_management.service;

import com.example.product_management.dto.request.ProductRequestDTO;
import com.example.product_management.dto.response.ProductResponseDTO;
import com.example.product_management.model.Product;
import com.example.product_management.model.Supplier;
import com.example.product_management.exception.ResourceNotFoundException;
import com.example.product_management.mapper.ProductMapper;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.repository.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldCreateProduct() {

        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setName("Laptop");
        dto.setPrice(50000.0);
        dto.setSupplierId(1L);

        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setIsActive(true);

        Product product = new Product();
        Product saved = new Product();
        saved.setId(1L);

        when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier));
        when(mapper.toEntity(dto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(saved);
        when(mapper.toResponse(saved))
                .thenReturn(new ProductResponseDTO(1L, "Laptop", 50000.0, null));

        ProductResponseDTO response = service.create(dto);

        assertNotNull(response);
        assertEquals(1L, response.getId());
    }

    @Test
    void shouldThrowIfSupplierNotFound() {

        when(supplierRepository.findById(1L)).thenReturn(Optional.empty());

        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setSupplierId(1L);

        assertThrows(ResourceNotFoundException.class,
                () -> service.create(dto));
    }
}