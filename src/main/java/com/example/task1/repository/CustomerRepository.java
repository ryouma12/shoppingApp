package com.example.task1.repository;

import com.example.task1.model.Accounts;
import com.example.task1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getCustomerById(Long id);


}
