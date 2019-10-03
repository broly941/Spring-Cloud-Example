package com.example.bookservice.employeeservice.controller;

import com.example.bookservice.employeeservice.mode.Employee;
import com.example.bookservice.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmpoloyeeController {
    private final EmployeeService employeeService;

    public EmpoloyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findlAll();
    }

    @GetMapping("{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

}
