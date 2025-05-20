package com.dante.mcc_customer_service.repository;

import com.dante.mcc_customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByCu(String customerId);

}
