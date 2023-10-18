package com.example.beanterestful.service.impl;

import com.example.beanterestful.entity.CustomerEntity;
import com.example.beanterestful.repository.CustomerRepository;
import com.example.beanterestful.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity updateCustomer(Long customerId, CustomerEntity customer) {
        if (customerRepository.existsById(customerId)) {
            customer.setCustomer_id(customerId);
            return customerRepository.save(customer);
        }
        return null;
    }
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }



}
