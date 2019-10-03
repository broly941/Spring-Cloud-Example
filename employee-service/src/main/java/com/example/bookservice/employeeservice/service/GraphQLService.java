package com.example.bookservice.employeeservice.service;

import com.example.bookservice.employeeservice.service.datafetcher.AllEmployeeDataFetcher;
import com.example.bookservice.employeeservice.service.datafetcher.DeleteEmployeeDataFetcher;
import com.example.bookservice.employeeservice.service.datafetcher.EmployeeDataFetcher;
import com.example.bookservice.employeeservice.service.datafetcher.NewEmployeeDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {
    private GraphQL graphQL;
    @Value("classpath:employees.graphql")
    private Resource resource;
    private final AllEmployeeDataFetcher allUserDataFetcher;
    private final EmployeeDataFetcher employeeDataFetcher;
    private final NewEmployeeDataFetcher newEmployeeDataFetcher;
    private final DeleteEmployeeDataFetcher deleteEmployeeDataFetcher;

    public GraphQLService(AllEmployeeDataFetcher allUserDataFetcher, EmployeeDataFetcher employeeDataFetcher, NewEmployeeDataFetcher newEmployeeDataFetcher, DeleteEmployeeDataFetcher deleteEmployeeDataFetcher) {
        this.allUserDataFetcher = allUserDataFetcher;
        this.employeeDataFetcher = employeeDataFetcher;
        this.newEmployeeDataFetcher = newEmployeeDataFetcher;
        this.deleteEmployeeDataFetcher = deleteEmployeeDataFetcher;
    }

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allEmployee", allUserDataFetcher)
                        .dataFetcher("employee", employeeDataFetcher))
                .type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("newEmployee", newEmployeeDataFetcher)
                        .dataFetcher("deleteEmployee", deleteEmployeeDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
