package com.example.task1.service;

import com.example.task1.dto.EmployeesDto;
import com.example.task1.dto.request.EmployeesRequest;

import java.util.List;

public interface EmployeesService {

    EmployeesDto getEmployeesById(Long id);

    void saveEmployees(EmployeesRequest employeesRequest);
    void updateEmployees(EmployeesRequest employeesRequest);

    List<EmployeesDto> getAll();

    void deleteById(Long id);



}
