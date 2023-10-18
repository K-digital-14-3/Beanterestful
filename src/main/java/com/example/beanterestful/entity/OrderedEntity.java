package com.example.beanterestful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ordered")

public class OrderedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_no;
    private int quantity;

    @OneToOne(mappedBy = "orderedEntity", cascade = CascadeType.ALL)
    private ProductEntity productEntity;

    @OneToOne
    @JoinColumn
    private OrderInfoEntity orderInfoEntity;
    // getters and setters

}
