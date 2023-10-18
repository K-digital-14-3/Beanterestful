package com.example.beanterestful.repository;

import com.example.beanterestful.entity.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderInfoEntity, Long> {

    OrderInfoEntity  findByOrderId(long orderId);
    OrderInfoEntity  findByOrderIdAndUserId(long orderId, long userId);
    OrderInfoEntity  save(OrderInfoEntity orderInfoEntity);

}
