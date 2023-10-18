package com.example.beanterestful.service;

import com.example.beanterestful.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    OrderDto updateOrder(OrderDto orderDto, Long orderId);
    void deleteOrder(Long id);
 /*
    OrderDto cancelOrder(Long id);
    OrderDto completeOrder(Long id);
    OrderDto getOrderByIdAndUserId(Long id, Long userId);
    OrderDto getOrderByIdAndUserIdAndStatus(Long id, Long userId, String status);
    OrderDto getOrderByIdAndUserIdAndStatusAndCreatedDate(Long id, Long userId, String status, String createdDate);
    OrderDto getOrderByIdAndUserIdAndStatusAndCreatedDateAndModifiedDate(Long id, Long userId, String status, String createdDate, String modifiedDate);
    OrderDto getOrderByIdAndUserIdAndStatusAndCreatedDateAndModifiedDateAndTotalPrice(Long id, Long userId, String status, String createdDate, String modifiedDate, Double totalPrice);
    OrderDto getOrderByIdAndUserIdAndStatusAndCreatedDateAndModifiedDateAndTotalPriceAndPaymentMethod(Long id, Long userId, String status, String createdDate, String modifiedDate, Double totalPrice, String paymentMethod);*/
}
