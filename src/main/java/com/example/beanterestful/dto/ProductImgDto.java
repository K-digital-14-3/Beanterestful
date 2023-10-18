package com.example.beanterestful.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

    @Getter
    @Setter
    public class ProductImgDto {

        private static ModelMapper modelMapper = new ModelMapper();
        private Long id;
        private String imgName;
        private String oriImgName;
        private String imgUrl;
        private String repImgYn;

        public static <productImg> ProductImgDto of(productImg productImg) {
            return modelMapper.map(productImg, ProductImgDto.class);
        }

    }
