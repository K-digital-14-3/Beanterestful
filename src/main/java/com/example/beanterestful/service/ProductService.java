package com.example.beanterestful.service;

import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.dto.ProductFormDto;
import com.example.beanterestful.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


public interface ProductService {
    ProductDto createProduct(ProductDto ProductDto);
    ProductResponse getAllProduct(int pageNo, int pageSize);
    ProductDto getProductById(int id);
    ProductDto updateProduct(ProductDto ProductDto, int id);
    void deleteProductId(int id);

    ProductFormDto saveProduct(ProductFormDto productFormDto,Long id);


    ProductFormDto seveproduct(ProductFormDto productFormDto, Long id);

    ProductFormDto seveproduct(ProductFormDto productFormDto, List<MultipartFile> multipartFileList);
}



