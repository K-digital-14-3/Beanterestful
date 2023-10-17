package com.example.beanterestful.controllers;


import com.example.beanterestful.dto.AddCartItemDto;
import com.example.beanterestful.dto.LoginDto;
import com.example.beanterestful.entity.CartEntity;
import com.example.beanterestful.entity.CartItemEntity;
import com.example.beanterestful.service.CartItemService;
import com.example.beanterestful.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping({"/cart"})
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartItemService cartItemService;  //

    @PostMapping
    // 유틸 (If Login) 이 없음 커스텀 어노테이션으로,
    // 아마 요청에서 로그인 된 사용자 정보를 가져오는 데 사용되는 것으로 보입니다.
    public CartItemEntity addCartItemEntity(LoginDto loginUserDto, @RequestBody AddCartItemDto addCartItemDto) {
        // 같은 cart에 같은 product가 있으면 quantity를 더해줘야함  //login dto//
        if (cartItemService.isCartItemExist(loginUserDto.getMemberId(), addCartItemDto.getCartId(), addCartItemDto.getProductId())) {
            CartItemEntity cartItemEntity = cartItemService.getCartItem(loginUserDto.getMemberId(), addCartItemDto.getCartId(), addCartItemDto.getProductId());
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + addCartItemDto.getQuantity());
            return cartItemService.updateCartItem(cartItemEntity);
        }
        return cartItemService.addCartItemEntity(addCartItemDto);
    }             //POST 메서드 - addCartItem
    //장바구니 항목을 추가하는 엔드포인트,이미 같은 제품이 장바구니에 있다면 수량을 증가시키고, 그렇지 않으면 새 항목을 추가


    @RestController // 추가  카트 api  부분
    @RequestMapping("/carts") // http://localhost:8080/carts
    @RequiredArgsConstructor
    public class CartApiController {
        private final CartService cartService;

        @PostMapping       // 이 두개 가 없음
        public CartEntity addCart(LoginDto loginUserDto) {
            LocalDate localDate = LocalDate.now();
            localDate.getYear();
            localDate.getDayOfMonth();
            localDate.getMonthValue();
            String date = String.valueOf(localDate.getYear()) + (localDate.getMonthValue() < 10 ? "0" : "") + String.valueOf(localDate.getMonthValue()) + (localDate.getDayOfMonth() < 10 ? "0" : "") + String.valueOf(localDate.getDayOfMonth());
            CartEntity CartEntity = cartService.addCartEntity(loginUserDto.getMemberId(), date);
            return CartEntity;
        }


        @DeleteMapping("/{cartItemId}")
        public ResponseEntity deleteCartItem(LoginDto loginUserDto, @PathVariable Long cartItemId) {
            if (cartItemService.isCartItemExist(loginUserDto.getMemberId(), cartItemId) == false)
                return ResponseEntity.badRequest().build();
            cartItemService.deleteCartItem(loginUserDto.getMemberId(), cartItemId);
            return ResponseEntity.ok().build();
        }
        //DELETE 메서드 - deleteCartItem
        //주어진 cartItemId로 장바구니 항목을 삭제하는 엔드포인트.
        //해당 항목이 존재하지 않으면 Bad Request 응답을 반환.


        @GetMapping                     // 유틸 @IfLogin 뻄
        public List<CartItemEntity> getCartItems(LoginDto loginUserDto, @RequestParam(required = false) Long cartId) {
            if (cartId == null                                //로그인 DTO 필요
            return cartItemService.getCartItems(loginUserDto.getMemberId());
            return cartItemService.getCartItems(loginUserDto.getMemberId(), cartId);
            //GET 메서드 - getCartItems
            //사용자의 장바구니 항목 목록을 반환하는 엔드포인트입니다.
            //cartId 파라미터가 제공되면 해당 장바구니의 항목만 반환하고,
            // 그렇지 않으면 모든 항목을 반환합니다.
        }
    }
}

