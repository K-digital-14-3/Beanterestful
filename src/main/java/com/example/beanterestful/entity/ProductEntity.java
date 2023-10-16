package com.example.beanterestful.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String product_id;


    private int price;
    private String product_name;
    private int  in_stock;
    private Date production_date;
    private String  volume;
    private String product_detail;
    private String  number_of_review;
    private String product_rating;
    private String   order_no;

    @OneToMany(mappedBy = "productEntity",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImageEntity> productImageEntityList = new ArrayList<ProductImageEntity>();




    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;


    @OneToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cartEntity;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

}
