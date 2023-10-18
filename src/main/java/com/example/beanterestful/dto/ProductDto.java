package com.example.beanterestful.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
public class ProductDto {
    private Long product_id;
    private int price;
    private String product_name;
    private int  in_stock;
    private Date production_date;
    private String volume;
    private String product_detail;
    private String number_of_review;
    private String product_rating;
}