package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.CategoryDto;
import com.example.beanterestful.entity.ProductEntity;
import com.example.beanterestful.service.CategoryService;
import com.example.beanterestful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

   /* @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {

        this.categoryService = categoryService;
        this.productService = productService;
    }*/

    @GetMapping("/categories/{category_id}")
    public ResponseEntity<CategoryDto> categoryId(@PathVariable Long category_id) {
        return ResponseEntity.ok(categoryService.getCategoryById(category_id));
    }

    @GetMapping("/categories/{category_id}/products")
    public ResponseEntity<List<ProductEntity>> getProductsByCategoryId(@PathVariable Long category_id) {
        List<ProductEntity> products = productService.getProductsByCategoryId(category_id);

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
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
