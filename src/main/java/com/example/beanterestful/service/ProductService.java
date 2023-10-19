package com.example.beanterestful.service;

import com.example.beanterestful.entity.ProductEntity;
import com.example.beanterestful.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  ProductService {
    private final ProductEntityRepository productRepository;

//    @Autowired
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    public List<ProductEntity> getProductsByCategoryId(Long categoryId) {
        List<ProductEntity> products = productRepository.findCategoryId(categoryId);

        // 잠시 주석.
        return products;

    }
}
