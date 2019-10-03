package com.example.bookservice.employeeservice.service.datafetcher;

import com.example.bookservice.employeeservice.mode.Employee;
import com.example.bookservice.employeeservice.repository.EmployeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class NewEmployeeDataFetcher implements DataFetcher<Employee> {
    private final EmployeeRepository employeeRepository;

    public NewEmployeeDataFetcher(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee get(DataFetchingEnvironment dataFetchingEnvironment) {
        Employee user = new Employee(dataFetchingEnvironment.getArgument("firstName"),
                dataFetchingEnvironment.getArgument("lastName"),
                dataFetchingEnvironment.getArgument("age"),
                dataFetchingEnvironment.getArgument("position"));
        return employeeRepository.save(user);
    }
}
