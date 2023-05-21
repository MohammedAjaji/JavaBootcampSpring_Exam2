package com.example.spring_test.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "ID cannot be empty")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Salary cannot be empty")
    private double salary;
}
