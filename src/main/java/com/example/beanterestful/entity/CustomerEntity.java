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
@Table(name = "customer")


public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private String customer_id;

    private String customer_account;
    private String email;
    private String password;
    private Date birthday;
    private int cell_number;
    private String address_detail;

    @OneToOne(mappedBy = "customer")
    private CartEntity cartEntity;

    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, orphanRemoval = true)
   private List<OrderInfoEntity> orderInfoEntityList = new ArrayList<OrderInfoEntity>();


}
