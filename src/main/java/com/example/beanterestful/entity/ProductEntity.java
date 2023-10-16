package com.example.beanterestful.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
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

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String email;
    private String password;
    private Date birthday;
    private int cell_number;
    private String address;
    private String address_detail;
}
