package com.example.beanterestful.service.impl;

import com.example.beanterestful.dto.ProductDto;
import com.example.beanterestful.dto.ProductFormDto;
import com.example.beanterestful.dto.ProductResponse;
import com.example.beanterestful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    /**
     * @param ProductDto
     * @return
     */
    @Override
    public ProductDto createProduct(ProductDto ProductDto) {
        return null;
    }

    /**
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ProductResponse getAllProduct(int pageNo, int pageSize) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductDto getProductById(int id) {
        return null;
    }

    /**
     * @param ProductDto
     * @param id
     * @return
     */
    @Override
    public ProductDto updateProduct(ProductDto ProductDto, int id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteProductId(int id) {

    }

    /**
     * @param productFormDto
     * @param id
     * @return
     */
    @Override
    public ProductFormDto saveProduct(ProductFormDto productFormDto, Long id) {
        return null;
    }

    /**
     * @param productFormDto
     * @param id
     * @return
     */
    @Override
    public ProductFormDto seveproduct(ProductFormDto productFormDto, Long id) {
        return null;
    }

    /**
     * @param productFormDto
     * @param multipartFileList
     * @return
     */
    @Override
    public ProductFormDto seveproduct(ProductFormDto productFormDto, List<MultipartFile> multipartFileList) {
        return null;
    }
    // ProductService 인터페이스에서 정의한 메서드들을 여기에 구현
}
