package com.example.bookservice.employeeservice.service.datafetcher;

import com.example.bookservice.employeeservice.mode.Employee;
import com.example.bookservice.employeeservice.repository.EmployeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllEmployeeDataFetcher implements DataFetcher<List<Employee>> {
    private final EmployeeRepository employeeRepository;

    public AllEmployeeDataFetcher(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> get(DataFetchingEnvironment dataFetchingEnvironment) {

        return employeeRepository.findAll();
    }
}
