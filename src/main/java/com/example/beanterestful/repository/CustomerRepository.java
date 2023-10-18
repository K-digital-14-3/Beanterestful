package com.example.beanterestful.repository;

import com.example.beanterestful.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // 여기에 고객 정보를 저장, 조회, 수정, 삭제하는 메서드를 정의할 수 있습니다.
    Customer findByEmailAndPwd(String email, String pwd);
    Customer findById(String username);
}