package com.example.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private double salary;
    private int experience;
    private String phone;
    private String email;


}
