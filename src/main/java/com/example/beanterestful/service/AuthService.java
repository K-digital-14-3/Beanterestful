package com.example.beanterestful.service;

import com.example.beanterestful.dto.LoginRequest;

public interface AuthService {
    boolean authenticate(LoginRequest loginRequest);
}