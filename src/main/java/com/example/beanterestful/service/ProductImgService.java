package com.example.beanterestful.service;

import com.example.beanterestful.repository.ProductImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductImgService<productImg> {

    private final ProductImgRepository productImgRepository;
    private static final com.example.beanterestful.service.FileService fileService = null;
    @Value("${productsImgLocation}")
    private String productsImgLocation;

    public void saveproductImg(productImg productImg,
                               MultipartFile productImgFile)
            throws Exception {
        String oriImgName = productImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        //파일 업로드
        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(productsImgLocation, oriImgName,
                    productImgFile.getBytes());
            imgUrl = "/images/products/" + imgName;
        }

        /*// 상품 이미지 정보 저장
        productImg.toString();
        ProductImgRepository.save(productImg);*/
    }

    public void updateproductImg(Long productImgId, MultipartFile productImgFile)
            throws Throwable {

        if (!productImgFile.isEmpty()) {
            productImg savedproductImg = (productImg) productImgRepository.findById(productImgId)
                    .orElseThrow(EntityNotFoundException::new);

            //기존 이미지 파일 삭제
            if (!StringUtils.isEmpty(String.valueOf(savedproductImg.getClass()))) {
                fileService.deleteFile(productsImgLocation + "/" +
                        savedproductImg.getClass());
            }


            String oriImgName = productImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(productsImgLocation, oriImgName, productImgFile.getBytes());
            String imgUrl = "/images/products/" + imgName;
            savedproductImg.toString();
        }
    }

    private void updateproductImg(String oriImgName, String imgName, String imgUrl) {

    }

    public void savedproductImg(productImg productImg, MultipartFile multipartFile) {
    }

}
