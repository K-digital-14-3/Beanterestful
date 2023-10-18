package com.example.beanterestful.service;

import com.example.beanterestful.dto.CategoryDto;
import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.entity.CategoryEntity;
import com.example.beanterestful.entity.ProductEntity;
import com.example.beanterestful.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    public CategoryDto getCategoryById(Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategory_id(category.getCategory_id());
            categoryDto.setCategory_name(category.getCategory_name());
            return categoryDto;
        } else {
            return null;
        }
    }
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        // productService를 사용하여 카테고리 ID에 해당하는 상품을 가져옵니다.
        return productService.getProductsByCategoryId(categoryId);
    }




    //아직 사용 x
    public CategoryDto createCategory(CategoryDto categoryDto) {

        CategoryEntity newCategory = new CategoryEntity();
        newCategory.setCategory_name(categoryDto.getCategory_name());

        CategoryEntity savedCategory = categoryRepository.save(newCategory);

        categoryDto.setCategory_id(savedCategory.getCategory_id());
        categoryDto.setCategory_name(savedCategory.getCategory_name());

        return categoryDto;
    }

    public CategoryDto updateCategory(Long category_id, CategoryDto categoryDto) {
        // ID로 카테고리 찾기
        CategoryEntity category = categoryRepository.findById(category_id).orElse(null);

        // 카테고리가 데이터베이스에 없다면 null 반환 또는 예외 발생
        if (category == null) {
            return null; // 또는 적절한 예외를 던지세요.
        }

        // 카테고리 정보 업데이트
        BeanUtils.copyProperties(categoryDto, category, "category_id");

        // 업데이트된 카테고리 저장
        CategoryEntity updatedCategory = categoryRepository.save(category);

        // 업데이트된 카테고리 정보를 DTO로 변환
        CategoryDto updatedCategoryDto = new CategoryDto();
        BeanUtils.copyProperties(updatedCategory, updatedCategoryDto);

        return updatedCategoryDto;
    }

}