package com.example.beanterestful.repository;

import com.example.beanterestful.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


    public interface ProductRepository2<Product> extends JpaRepository<ProductEntity, Long> {
        Optional<Product> findByType(String type);
        
        public interface ProductRepository<Product, ProductSearchDto, MainProductDto>
                extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product>,
                ProductRepositoryCustom {
            List<Product> findByProductNm(String ProductNm);
            List<Product> findByProductNmOrProductDetail(String ProductNm, String ProductDetail);
            List<Product> findByPriceLessThan(Integer price);
            List<Product> findByPriceLessThanOrderByPriceDesc(Integer price);

            // JPQL 쿼리 사용
            @Query("select i from Product i where i.Product_detail like " +
                    "%:ProductDetail% order by i.price desc")
            List<Product> findByProductDetailBtNative(@Param("ProductDetail") String ProductDetail);

            // 네이티브 SQL 쿼리 사용
            @Query(value="select * from Product i where i.Product_detail like " +
                    "%:ProductDetail% order by i.price desc", nativeQuery = true)
            List<Product> findByProductDetailByNative(@Param("ProductDetail") String ProductDetail);
            
            Page<MainProductDto> getMainProductPage(Object ProductearchDto, Pageable pageable);}

    }


