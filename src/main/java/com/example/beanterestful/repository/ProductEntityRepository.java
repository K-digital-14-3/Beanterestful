package com.example.beanterestful.repository;

import com.example.beanterestful.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    //query 필요하고, 일단 주석
    @Query("select p from ProductEntity p join p.categoryEntity c where c.category_id = : category_id")


    List<ProductEntity> findCategoryId(@Param("category_id")Long categoryId);
}
