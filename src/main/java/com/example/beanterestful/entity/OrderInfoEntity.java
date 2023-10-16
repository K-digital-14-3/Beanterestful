package com.example.beanterestful.entity;


import jakarta.persistence.*;
import java.util.Date;


public class OrderInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    public CustomerEntity customerEntity;

    @Id	@Column(name = "order_no")
    private int order_no;

    private String email;
    private String address;
    private String  address_detail;
    private Date order_date;
    private String delivery_status;
    private String receiver_name;
    private String delivery_request;
    private int total_price;

    @OneToOne(mappedBy = "board")
    private int order_no;

}
