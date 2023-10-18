package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.CustomerDto;
import com.example.beanterestful.entity.Customer;
import com.example.beanterestful.repository.CustomerRepository;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class AccountController {
    @PostMapping("/api/account/login")
    public int login(@RequestBody Map<String,String> params) {

        Customer customer = customerRepository.findByEmailAndPwd(params.get("email"), params.get("pwd"));
        log.info("customer = " + customer);


        if (customer != null) {

            return Customer.getId();

        }

    }

    //로그아웃
    @PostMapping("/api/account/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인 체크
 /*   @GetMapping("/shop/account/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);
        log.info("claims = "+ claims);
        if (claims != null) {
            int id = Integer.parseInt(claims.get("id").toString());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
    }*/
}

