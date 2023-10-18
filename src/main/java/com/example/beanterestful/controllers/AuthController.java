package com.example.beanterestful.controllers;

import com.example.beanterestful.dto.LoginRequest;
import com.example.beanterestful.dto.UserRegistrationRequest;
import com.example.beanterestful.entity.UserEntity;
import com.example.beanterestful.service.AuthService;
import com.example.beanterestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest) {
        if (authService.authenticate(loginRequest)) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest registrationRequest) {
        UserEntity existingUser = userService.registerUser(registrationRequest);
        if (existingUser != null) {
            return ResponseEntity.ok("계정 생성");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
        }
    }
}