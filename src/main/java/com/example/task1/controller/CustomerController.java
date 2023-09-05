package com.example.task1.controller;

import com.example.task1.dto.CustomerDto;
import com.example.task1.dto.request.CustomerRequest;
import com.example.task1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")

public class CustomerController {

    final CustomerService customerService;

    @GetMapping(value = "/customerList")
    public List<CustomerDto> getCustomerInfo(){
        return customerService.getAll();
    }

    @GetMapping(value = "/getCustomerById/{id}")
    public CustomerDto getCustomerById(@PathVariable(value = "id")Long id){
        return customerService.getAllCustomerById(id);
    }

    @PostMapping(value = "/saveCustomer")
    public void saveCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.saveCustomer(customerRequest);
    }

    @PostMapping(value = "/updateCustomer")
    public void updateCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.updateCustomer(customerRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        customerService.deleteById(id);
    }

}
