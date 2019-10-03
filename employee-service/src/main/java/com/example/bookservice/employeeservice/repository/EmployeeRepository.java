package com.example.bookservice.employeeservice.repository;

import com.example.bookservice.employeeservice.mode.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
