package com.example.product_management.controller;

import com.example.product_management.dto.request.StockRequestDTO;
import com.example.product_management.dto.response.StockResponseDTO;
import com.example.product_management.service.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;

    @PostMapping
    public ResponseEntity<StockResponseDTO> createOrUpdate(
            @Valid @RequestBody StockRequestDTO dto) {

        return ResponseEntity.ok(service.createOrUpdate(dto));
    }
}
