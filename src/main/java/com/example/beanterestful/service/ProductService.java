package com.example.beanterestful.service;

import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.entity.ProductEntity;
import com.example.beanterestful.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        // DB에서 카테고리 ID에 해당하는 상품 리스트를 가져옵니다.
        List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);

        // Entity 리스트를 DTO 리스트로 변환합니다.
        return productEntities.stream().map(product -> {
            ProductDto dto = new ProductDto();
            dto.setProduct_id(product.getProduct_id());
            dto.setProduct_name(product.getProduct_name());
            dto.setPrice(product.getPrice());
            dto.setIn_stock(product.getIn_stock());
            dto.setProduction_date(product.getProduction_date());
            dto.setVolume(product.getVolume());
            dto.setProduct_detail(product.getProduct_detail());
            dto.setProduct_rating(product.getProduct_rating());
            return dto;
        }).collect(Collectors.toList());
    }
}