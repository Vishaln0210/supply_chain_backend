package com.example.product_management.service;

import com.example.product_management.dto.request.OrderItemRequestDTO;
import com.example.product_management.dto.request.OrderRequestDTO;
import com.example.product_management.dto.response.OrderItemResponseDTO;
import com.example.product_management.dto.response.OrderResponseDTO;
import com.example.product_management.model.*;
import com.example.product_management.repository.OrderRepository;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    public OrderResponseDTO create(OrderRequestDTO dto) {

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequestDTO itemDTO : dto.getItems()) {

            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("PRODUCT_NOT_FOUND"));

            Stock stock = stockRepository
                    .findByProductIdAndWarehouseId(product.getId(), 1L)
                    .orElseThrow(() -> new RuntimeException("STOCK_NOT_FOUND"));

            if (stock.getQuantity() < itemDTO.getQuantity()) {
                throw new RuntimeException("INSUFFICIENT_STOCK");
            }

            // reduce stock
            stock.setQuantity(stock.getQuantity() - itemDTO.getQuantity());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());

            orderItems.add(orderItem);
        }

        order.setItems(orderItems);

        Order saved = orderRepository.save(order);

        List<OrderItemResponseDTO> responseItems = saved.getItems().stream()
                .map(i -> new OrderItemResponseDTO(
                        i.getProduct().getId(),
                        i.getQuantity()))
                .toList();

        return new OrderResponseDTO(
                saved.getId(),
                saved.getStatus().name(),
                responseItems
        );
    }
}
