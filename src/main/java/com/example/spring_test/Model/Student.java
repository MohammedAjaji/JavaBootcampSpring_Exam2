package com.example.spring_test.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    @NotNull(message = "ID cannot be empty")
    @Min(value = 100, message = "id should be 3 size or more")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 18, message = "Age should be 18+")
    private int age;

    @NotEmpty(message = "major cannot be empty")
    private String major;
}
