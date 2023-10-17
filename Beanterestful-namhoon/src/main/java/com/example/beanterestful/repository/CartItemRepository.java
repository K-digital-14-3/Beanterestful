package com.example.beanterestful.repository;

import com.example.beanterestful.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    boolean existsByCart_memberIdAndCart_idAndProductId(Long memberId, Long cartId, Long productId);
    Optional<CartItemEntity> findByCart_memberIdAndCart_idAndProductId(Long memberId, Long cartId, Long productId);

    boolean existsByCart_memberIdAndId(Long memberId, Long cartItemId);
    void deleteByCart_memberIdAndId(Long memberId, Long cartItemId);

    List<CartItemEntity> findByCart_memberIdAndCart_id(Long memberId, Long cartId);

    List<CartItemEntity> findByCart_memberId(Long memberId);
}
