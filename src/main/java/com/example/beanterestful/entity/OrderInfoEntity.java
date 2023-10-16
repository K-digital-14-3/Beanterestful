package com.example.beanterestful.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


public class OrderInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customer_id;
    private int  order_no;
    private String email;
    private String address;
    private String  address_detail;
    private Date order_date;
    private String delivery_status;
    private String receiver_name;
    private String delivery_request;
    private int total_price;

}
