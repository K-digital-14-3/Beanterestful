package com.example.beanterestful.service.impl;

import com.example.beanterestful.dto.UserRegistrationRequest;
import com.example.beanterestful.entity.UserEntity;
import com.example.beanterestful.repository.UserRepository;
import com.example.beanterestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(UserRegistrationRequest registrationRequest) {
        // 추가적인 유효성 검사 및 중복 사용자 확인 가능
        UserEntity user = new UserEntity();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());
        return userRepository.save(user);
    }
}