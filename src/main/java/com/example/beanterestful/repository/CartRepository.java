package com.example.beanterestful.repository;

import com.example.beanterestful.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository  extends JpaRepository<CartEntity, Long> {
    Optional<CartEntity> findByMemberIdAndDate(Long memberId, String date);

}