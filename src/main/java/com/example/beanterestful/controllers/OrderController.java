package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.OrderDto;
import com.example.beanterestful.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    private OrderService orderService;
    public  OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("orders/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }
    @GetMapping("orders/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    @PutMapping("orders/{orderId}/update")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long orderId){
        return ResponseEntity.ok(orderService.updateOrder(orderDto, orderId));
    }

    @DeleteMapping("orders/{orderId}/delete")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>("order deleted", HttpStatus.OK);
    }
}