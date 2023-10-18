package com.example.beanterestful.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    private String username;
    private String password;

    // getters and setters
}