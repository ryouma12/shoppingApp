package com.example.task1.service.impl;

import com.example.task1.dto.CustomerDto;
import com.example.task1.dto.request.CustomerRequest;
import com.example.task1.model.Customer;
import com.example.task1.repository.CustomerRepository;
import com.example.task1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;


    @Override
    public CustomerDto getAllCustomerById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);

        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .userName(customer.getUserName())
                .build();
    }

    @Override
    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .userName(customerRequest.getUserName())
                .address(customerRequest.getAddress())
                .contactADD(customerRequest.getContactADD())
                .passWord(customerRequest.getPassWord())
                .build();


        customerRepository.save(customer);


    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .id(customerRequest.getId())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .userName(customerRequest.getUserName())
                .address(customerRequest.getAddress())
                .contactADD(customerRequest.getContactADD())
                .passWord(customerRequest.getPassWord())
                .build();

        customerRepository.save(customer);

    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for(Customer customer : customers){
            CustomerDto customerDto = CustomerDto.builder()
                    .userName(customer.getUserName())
                    .lastName(customer.getLastName())
                    .userName(customer.getUserName())
                    .build();

            customerDtos.add(customerDto);


        }
        return customerDtos ;
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);

        if(customer.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            customerRepository.deleteById(id);
        }
    }
}
