package com.example.bookservice.employeeservice.controller;

import com.example.bookservice.employeeservice.service.GraphQLService;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/employees-graphql")
public class EmployeeGraphQLController {

    private final GraphQLService qlService;

    public EmployeeGraphQLController(GraphQLService qlService) {
        this.qlService = qlService;
    }

    @PostMapping
    public ResponseEntity<Object> start(@RequestBody String query) {
        ExecutionResult result = qlService.getGraphQL().execute(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
