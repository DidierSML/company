package com.example.company.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotNull
    private int id;

    @NotEmpty
    @Size(min = 2, message = "The Employee´s name must be at least 2 characters long")
    private String name;

    @NotEmpty
    @Size(min = 2, message = "The Employee´s last name must be at least 2 characters long")
    private String lastName;

    @NotNull
    @Min(value = 18)
    @Max(value = 70)
    private int age;

    @NotNull
    @Min(value = 500)
    @Max(value = 2500)
    private double salary;

    @NotNull
    @Min(value = 1)
    @Max(value = 20)
    private int experience;

    @Size(min = 10, max = 10, message = "The phone number must be exactly ten digits long")
    @Pattern(regexp = "\\d+", message = "The phone number must contain only digits")
    private String phone;

    @NotEmpty(message = "Email Must not be Null or Empty")
    @Email
    private String email;

}

/*
 @NotEmpty integra (@NotNull y @NotBlank) pero solo funciona para tipos de dato String
 Si vamos a trabajar con datos como int o double la alternativa es @NotNull


 */
