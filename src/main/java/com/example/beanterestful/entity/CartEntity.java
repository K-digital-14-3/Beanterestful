package com.example.beanterestful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cart_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "cartEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> cartItems = new ArrayList<CartItemEntity>();
}


