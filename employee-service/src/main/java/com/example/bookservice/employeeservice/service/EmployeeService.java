package com.example.bookservice.employeeservice.service;

import com.example.bookservice.employeeservice.mode.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findlAll();

    Employee findById(Long id);

    Employee create(Employee employee);

    void delete(Long id);
}
