package com.example.beanterestful.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long productId;
    private int price;
    private String productName;
    private int inStock;
    private Date productionDate;
    private String volume;
    private String productDetail;
    private String numberOfReview;
    private String productRating;

    // 연관된 엔티티의 ID 또는 필요한 정보만 포함
    private Long categoryId;
    private Long cartId;
    private Long orderNo;
    private Long customerId;

    // ProductImageEntity의 정보를 포함할 수 있는 DTO 리스트
    // 이 경우에는 이미지 URL 등 필요한 정보만 포함하는 것이 좋습니다.
    private List<String> productImageUrls; // 예를 들어, 이미지 URL 리스트

    // 추가로 필요한 정보를 DTO에 포함할 수 있습니다.
    // 예를 들어, 카테고리 이름, 고객 정보 등
    private String categoryName;
}
