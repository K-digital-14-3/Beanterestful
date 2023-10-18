package com.example.beanterestful.service;

import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.entity.CategoryEntity;
import com.example.beanterestful.repository.ProductRepository2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final ProductRepository2 ProductRepository;

    @Autowired
    public CategoryService(ProductRepository2 ProductRepository2) {
        this.ProductRepository = ProductRepository2;
    }

    public ProductDto getCategoryById(Long id) {
        CategoryEntity Category = (CategoryEntity) ProductRepository.findById(id).orElse(null);
        if (Category != null) {
            ProductDto ProductDto = new ProductDto();
            ProductDto.setCategory_id(Category.getCategory_id());
            ProductDto.setCategory_name(Category.getCategory_name());
            return ProductDto;
        } else {
            return null;
        }
    }

    //아직 사용 x
    public ProductDto createCategory(ProductDto ProductDto) {

        CategoryEntity newCategory = new CategoryEntity();
        newCategory.setCategory_name(ProductDto.getCategory_name());

        CategoryEntity savedCategory = (CategoryEntity) ProductRepository.save(newCategory);

        ProductDto.setCategory_id(savedCategory.getCategory_id());
        ProductDto.setCategory_name(savedCategory.getCategory_name());

        return ProductDto;
    }

    public ProductDto updateCategory(Long Category_id, ProductDto ProductDto) {
        // ID로 카테고리 찾기
        CategoryEntity Category = (CategoryEntity) ProductRepository.findById(Category_id).orElse(null);

        // 카테고리가 데이터베이스에 없다면 null 반환 또는 예외 발생
        if (Category == null) {
            return null; // 또는 적절한 예외를 던지세요.
        }

        // 카테고리 정보 업데이트
        BeanUtils.copyProperties(ProductDto, Category, "Category_id");

        // 업데이트된 카테고리 저장
        CategoryEntity updatedCategory = (CategoryEntity) ProductRepository.save(Category);

        // 업데이트된 카테고리 정보를 DTO로 변환
        ProductDto updatedProductDto = new ProductDto();
        BeanUtils.copyProperties(updatedCategory, updatedProductDto);

        return updatedProductDto;
    }

}