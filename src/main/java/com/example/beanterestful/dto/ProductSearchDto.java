package com.example.beanterestful.dto;

import com.example.beanterestful.constant.ProductSellStatus;
import lombok.Getter;
import lombok.Setter;


    @Getter
    @Setter
    public class ProductSearchDto {

        private String searchDateType;

        private ProductSellStatus searchSellStatus;

        private String searchBy;

        private String searchQuery = "";

    }

