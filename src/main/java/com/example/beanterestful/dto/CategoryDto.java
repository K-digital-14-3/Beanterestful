package com.example.beanterestful.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long category_id;
    private String category_name;
    private List<ProductDto> ProductDtoList =new ArrayList<>();
}
