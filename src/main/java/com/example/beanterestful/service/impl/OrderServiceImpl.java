package com.example.beanterestful.service.impl;


import com.example.beanterestful.dto.OrderDto;
import com.example.beanterestful.repository.OrderRepository;
import com.example.beanterestful.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        return null;
    }
    @Override
    public OrderDto  getOrderById(Long id) {

        return null;
    }
    @Override
    public OrderDto  updateOrder(OrderDto orderDto, Long id) {

        return null;
    }
    @Override
    public  void  deleteOrder(Long id) {

        deleteOrder
    }

}
