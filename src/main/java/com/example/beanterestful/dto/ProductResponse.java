package com.example.beanterestful.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private List<ProductDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    private int id;
    private String name;
    private String type;
    private Integer price;
    private String productDetail;
    private String sellStatCd;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    public void setCategory_id(Long categoryId){

    }

    public void setCategory_name(String categoryName) {
    }

    public String getCategory_name() {
        return null;
    }
}



