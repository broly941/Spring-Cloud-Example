package com.example.bookservice.employeeservice.service.datafetcher;

import com.example.bookservice.employeeservice.mode.Employee;
import com.example.bookservice.employeeservice.service.EmployeeService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataFetcher implements DataFetcher<Employee> {
    private final EmployeeService employeeService;

    public EmployeeDataFetcher(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer id = dataFetchingEnvironment.getArgument("id");
        return employeeService.findById(id.longValue());
    }
}
