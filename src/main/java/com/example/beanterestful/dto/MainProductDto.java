package com.example.beanterestful.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainProductDto {

    private Long id;

    private String productsNm;

    private String productsDetail;

    private String imgUrl;

    private Integer price;

    @QueryProjection
    public MainProductDto(Long id, String productsNm, String productsDetail, String imgUrl, Integer price) {
        this.id = id;
        this.productsNm = productsNm;
        this.productsDetail = productsDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }

}