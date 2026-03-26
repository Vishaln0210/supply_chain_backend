package com.example.product_management.service;

import com.example.product_management.dto.request.WarehouseRequestDTO;
import com.example.product_management.dto.response.WarehouseResponseDTO;
import com.example.product_management.mapper.WarehouseMapper;
import com.example.product_management.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.product_management.model.Warehouse;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository repository;
    private final WarehouseMapper mapper;

    public WarehouseResponseDTO create(WarehouseRequestDTO dto) {
        Warehouse saved = repository.save(mapper.toEntity(dto));
        return mapper.toResponse(saved);
    }
}
