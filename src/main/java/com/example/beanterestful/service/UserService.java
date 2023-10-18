package com.example.beanterestful.service;

import com.example.beanterestful.dto.UserRegistrationRequest;
import com.example.beanterestful.entity.UserEntity;

public interface UserService {
    UserEntity registerUser(UserRegistrationRequest registrationRequest);
}