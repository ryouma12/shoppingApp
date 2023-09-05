package com.example.task1.repository;

import com.example.task1.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    Employees getEmployeesById(Long id);
}
