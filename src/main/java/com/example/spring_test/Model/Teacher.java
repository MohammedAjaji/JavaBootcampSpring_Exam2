package com.example.spring_test.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "ID cannot be empty")
    @Min(value = 100, message = "id should be 3 size or more")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Salary cannot be empty")
    @Positive(message = "salary cannot be negative")
    @Min(value = 1000, message = "salary should be more than 1000")
    private double salary;
}
