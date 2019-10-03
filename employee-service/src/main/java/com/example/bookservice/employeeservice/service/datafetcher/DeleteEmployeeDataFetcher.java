package com.example.bookservice.employeeservice.service.datafetcher;

import com.example.bookservice.employeeservice.repository.EmployeeRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmployeeDataFetcher implements DataFetcher<Boolean> {
    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeDataFetcher(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Boolean get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer id = dataFetchingEnvironment.getArgument("id");
        employeeRepository.deleteById(id.longValue());
        return true;
    }
}
