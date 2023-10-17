package com.example.beanterestful.service;



import com.example.beanterestful.dto.AddCartItemDto;

import com.example.beanterestful.entity.CartEntity;

import com.example.beanterestful.entity.CartItemEntity;
import com.example.beanterestful.repository.CartItemRepository;
import com.example.beanterestful.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //생성자가 자동으로 생성
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    //카트 항목 데이터를 조작하기 위한 리포지토리
    private final CartRepository cartRepository;
    // 카트 데이터를 조작하기 위한 리포지토리.

    @Transactional
    public CartItemEntity addCartItemEntity(AddCartItemDto addCartItemDto) {
        CartEntity cartEntity = cartRepository.findById(addCartItemDto.getCartId()).orElseThrow();

        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setCartEntity(cartEntity);
        cartItem.setQuantity(addCartItemDto.getQuantity());
        cartItem.setProductId(addCartItemDto.getProductId());
        cartItem.setProductPrice(addCartItemDto.getProductPrice());
        cartItem.setProductTitle(addCartItemDto.getProductTitle());
        cartItem.setProductDescription(addCartItemDto.getProductDescription());

        return cartItemRepository.save(cartItemEntity);
    }

    @Transactional(readOnly = true)
    public boolean isCartItemExist(Long Cart_id, Long cartId, Long productId) {
        boolean check = cartItemRepository.existsByCart_memberIdAndCart_idAndProductId(memberId, cartId, productId);
        return check;
    }

    @Transactional(readOnly = true)
    public CartEntity getCartItem(Long Cart_id, Long cartId, Long productId) {
        return cartItemRepository.findByCart_memberIdAndCart_idAndProductId(memberId, cartId, productId).orElseThrow();
    }

    @Transactional
    public CartItemEntity updateCartItem(CartItemEntity cartItemEntity) {
        CartItemEntity findCartItem = cartItemRepository.findById(cartItemEntity.getId()).orElseThrow();
        findCartItem.setQuantity(cartItemEntity.getQuantity());
        return findCartItem;
    }

    @Transactional(readOnly = true)
    public boolean isCartItemExist(Long Cart_id, Long cartItemId) {
        return cartItemRepository.existsByCart_memberIdAndId(Cart_id, cartItemId);
    }

    @Transactional
    public void deleteCartItem(Long Cart_id, Long cartItemId) {
        cartItemRepository.deleteByCart_memberIdAndId(Cart_id, cartItemId);
    }

    @Transactional(readOnly = true)
    public List<CartEntity> getCartItems(Long Cart_id, Long cartId) {
        return cartItemRepository.findByCart_memberIdAndCart_id(Cart_id, cartId);
    }

    @Transactional(readOnly = true)
    public List<CartEntity> getCartItems(Long Cart_id) {
        return cartItemRepository.findByCart_Id(Cart_id);
    }
}
