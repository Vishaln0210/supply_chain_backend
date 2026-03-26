package com.example.product_management.service;

import com.example.product_management.dto.request.StockRequestDTO;
import com.example.product_management.dto.response.StockResponseDTO;
import com.example.product_management.mapper.StockMapper;
import com.example.product_management.model.Product;
import com.example.product_management.model.Stock;
import com.example.product_management.model.Warehouse;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.repository.StockRepository;
import com.example.product_management.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final StockMapper mapper;

    public StockResponseDTO createOrUpdate(StockRequestDTO dto) {

        Stock stock = stockRepository
                .findByProductIdAndWarehouseId(dto.getProductId(), dto.getWarehouseId())
                .orElseGet(Stock::new);

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("PRODUCT_NOT_FOUND"));

        Warehouse warehouse = warehouseRepository.findById(dto.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("WAREHOUSE_NOT_FOUND"));

        stock.setProduct(product);
        stock.setWarehouse(warehouse);
        stock.setQuantity(dto.getQuantity());

        Stock saved = stockRepository.save(stock);

        return mapper.toResponse(saved);
    }
}