package com.example.company.dto.request;

import lombok.Data;

@Data
public class EmployeeRequest {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private double salary;
    private int experience;
    private int phone;
    private String email;

}
