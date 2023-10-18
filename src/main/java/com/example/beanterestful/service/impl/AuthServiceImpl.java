package com.example.beanterestful.service.impl;

import com.example.beanterestful.dto.LoginRequest;
import com.example.beanterestful.entity.UserEntity;
import com.example.beanterestful.repository.UserRepository;
import com.example.beanterestful.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());
        return user != null && user.getPassword().equals(loginRequest.getPassword());
    }
}