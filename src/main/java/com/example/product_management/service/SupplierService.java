package com.example.product_management.service;

import com.example.product_management.dto.request.SupplierRequestDTO;
import com.example.product_management.dto.response.SupplierResponseDTO;
import com.example.product_management.model.Supplier;
import com.example.product_management.mapper.SupplierMapper;
import com.example.product_management.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    public SupplierResponseDTO create(SupplierRequestDTO dto) {
        Supplier supplier = mapper.toEntity(dto);
        supplier.setIsActive(true);
        return mapper.toResponse(repository.save(supplier));
    }

    public List<SupplierResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public SupplierResponseDTO getById(Long id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return mapper.toResponse(supplier);
    }

    public SupplierResponseDTO update(Long id, SupplierRequestDTO dto) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplier.setName(dto.getName());
        supplier.setContactEmail(dto.getContactEmail());

        return mapper.toResponse(repository.save(supplier));
    }

    public void delete(Long id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        repository.delete(supplier);
    }
}