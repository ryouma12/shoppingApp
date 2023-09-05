package com.example.task1.service;

import com.example.task1.dto.CustomerDto;
import com.example.task1.dto.request.CustomerRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto getAllCustomerById(Long id);

    void saveCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    List<CustomerDto> getAll();

    void deleteById(Long id);


}
