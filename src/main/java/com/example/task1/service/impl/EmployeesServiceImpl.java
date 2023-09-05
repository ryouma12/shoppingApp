package com.example.task1.service.impl;

import com.example.task1.dto.EmployeesDto;
import com.example.task1.dto.request.EmployeesRequest;
import com.example.task1.model.Employees;
import com.example.task1.repository.EmployeesRepository;
import com.example.task1.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeesServiceImpl implements EmployeesService {

    final EmployeesRepository employeesRepository;


    @Override
    public EmployeesDto getEmployeesById(Long id) {

        Employees employees = employeesRepository.getEmployeesById(id);

        return EmployeesDto.builder()
                .firstName(employees.getFirstName())
                .lastName(employees.getLastName())
                .userName(employees.getUserName())
                .build();


    }

    @Override
    public void saveEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .userName(employeesRequest.getUserName())
                .lastName(employeesRequest.getLastName())
                .firstName(employeesRequest.getFirstName())
                .build();


        employeesRepository.save(employees);
    }

    @Override
    public void updateEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .id(employeesRequest.getId())
                .firstName(employeesRequest.getFirstName())
                .lastName(employeesRequest.getLastName())
                .address(employeesRequest.getAddress())
                .contactADD(employeesRequest.getContactADD())
                .passWord(employeesRequest.getPassWord())
                .build();

        employeesRepository.save(employees);

    }

    @Override
    public List<EmployeesDto> getAll() {

        List<Employees> employees = employeesRepository.findAll();
        List<EmployeesDto> employeesDtos = new ArrayList<>();

        for(Employees employees1 : employees){
            EmployeesDto employeesDto = EmployeesDto.builder()
                    .firstName(employees1.getFirstName())
                    .lastName(employees1.getLastName())
                    .userName(employees1.getUserName())
                    .build();

            employeesDtos.add(employeesDto);
        }

        return employeesDtos;
    }

    @Override
    public void deleteById(Long id) {
        Employees employees = employeesRepository.getEmployeesById(id);
        if(employees.getId().equals(null)){
            throw new RuntimeException("");

        }
        else {
            employeesRepository.deleteById(id);
        }
    }


}
