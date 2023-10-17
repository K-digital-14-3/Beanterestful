package com.example.beanterestful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cartItem")

public class CartItemEntity {

    @Id
    private Long cart_id;

    private int quantity;

    @MapsId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    @OneToOne(mappedBy = "cartItemEntity")
    private ProductEntity productentity;

  }
