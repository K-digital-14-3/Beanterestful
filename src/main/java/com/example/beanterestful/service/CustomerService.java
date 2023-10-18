package com.example.beanterestful.service;

import com.example.beanterestful.entity.CustomerEntity;

public interface CustomerService {
    CustomerEntity getCustomerById(Long customerId);
    CustomerEntity createCustomer(CustomerEntity customer);
    CustomerEntity updateCustomer(Long customerId, CustomerEntity customer);
    void deleteCustomer(Long customerId);


}