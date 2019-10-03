package com.example.bookservice.employeeservice.mode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Employee extends AbstractPersistable<Long> {
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NonNull
    @Column(name = "age", nullable = false)
    private Integer age;
    @NonNull
    @Column(name = "position", nullable = false)
    private String position;
}
