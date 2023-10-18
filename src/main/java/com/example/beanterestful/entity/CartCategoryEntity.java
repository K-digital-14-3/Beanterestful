package com.example.beanterestful.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cartCategory")

public class CartCategoryEntity {

    @Id
    private Long cart_id;

    private int quantity;

    @MapsId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;

    @OneToOne(mappedBy = "cartCategoryEntity")
    private CategoryEntity Categoryentity;

  }
