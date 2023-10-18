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

   @Service
    public class ProductService2 <ProductFormDto>{

        public Long saveproduct(ProductFormDto productFormDto,
                                 List<MultipartFile> multipartFileList) {
            return null;
        }

    public Object getAllProduct(int pageNo, int pageSize) {
        return null;
    }

    public Object getProductById(int id) {
        return null;
    }

    public Object createProduct(ProductDto productDto) {
        return null;
    }
}
