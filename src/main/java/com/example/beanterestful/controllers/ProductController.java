package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class ProductController<ProductResponse> {

    private ProductService ProductService;

    @Autowired
    public ProductController(ProductService productService) {
        this.ProductService = productService;
    }

    @GetMapping("Product")
    public ResponseEntity<ProductResponse> getProducts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return (ResponseEntity<ProductResponse>) new ResponseEntity<>(ProductService.getAllProduct(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("Product/{id}")
    public ResponseEntity<ProductDto> ProductDetail(@PathVariable int id) {
        return ResponseEntity.ok((ProductDto) ProductService.getProductById(id));

    }

}


