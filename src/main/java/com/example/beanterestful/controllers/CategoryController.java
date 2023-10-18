package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService CategoryService;

    @Autowired
    public CategoryController(CategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }

    @GetMapping("/categories/{Category_id}")
    public ResponseEntity<CategoryDto> CategoryId(@PathVariable Long Category_id) {
        return ResponseEntity.ok(CategoryService.getCategoryById(Category_id));
    }


    //아직 사용x
    @PostMapping("/categories/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto CategoryDto) {
        CategoryDto createdCategoryDto = CategoryService.createCategory(CategoryDto);

        if (createdCategoryDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/categories/update/{Category_id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long Category_id, @RequestBody CategoryDto CategoryDto) {
        try {
            CategoryDto updatedCategoryDto = CategoryService.updateCategory(Category_id, CategoryDto);

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
