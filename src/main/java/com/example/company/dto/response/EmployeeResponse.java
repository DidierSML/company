package com.example.company.dto.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private double salary;
    private int experience;
    private String phone;
    private String email;

}
