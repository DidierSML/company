package com.example.company.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

        private int id;

        @NotBlank
        private String name;
        @NotBlank
        private String lastName;
        @NotNull(message = "Age can not be null")
        private int age;
        @NotNull(message = "salary can not be null")
        private double salary;
        @NotNull(message = "experience can not be null")
        private int experience;
        @NotBlank
        private String phone;
        @Email
        private String email;

}
