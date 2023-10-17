package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.CategoryDto;
import com.example.beanterestful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/{category_id}")
    public ResponseEntity<CategoryDto> categoryId(@PathVariable Long category_id) {
        return ResponseEntity.ok(categoryService.getCategoryById(category_id));
    }


    //아직 사용x
    @PostMapping("/categories/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategoryDto = categoryService.createCategory(categoryDto);

        if (createdCategoryDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/categories/update/{category_id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long category_id, @RequestBody CategoryDto categoryDto) {
        try {
            CategoryDto updatedCategoryDto = categoryService.updateCategory(category_id, categoryDto);

            if (updatedCategoryDto != null) {
                return ResponseEntity.ok(updatedCategoryDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
