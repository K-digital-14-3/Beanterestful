package com.example.beanterestful.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



public class OrderedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_no;
    private int quantity;

}
