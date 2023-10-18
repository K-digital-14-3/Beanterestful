package com.example.beanterestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface
ProductImgRepository<products, product, productImg> extends JpaRepository<products, Long>,
        QuerydslPredicateExecutor<products>, com.example.beanterestful.repository.ProductRepositoryCustom {

    List<product> findByproductsNm(String productsNm);

    List<product> findByproductsNmOrproductsDetail(String productsNm, String productsDetail);

    List<product> findByPriceLessThan(Integer price);

    List<product> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from product i where i.productDetail like " +
            "%:productsDetail% order by i.price desc")
    List<product> findByproductsDetail(@Param("productsDetail") String productsDetail);

    @Query(value = "select * from products i where i.product_detail like " +
            "%:productsDetail% order by i.price desc", nativeQuery = true)
    List<product> findByproductsDetailByNative(@Param("productsDetail") String productsDetail);

    List<productImg> findByproductsIdOrderByIdAsc(Long productsId);



}