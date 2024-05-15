package com.example.company.service;

import com.example.company.dto.EmployeeDto;
import com.example.company.dto.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeRequest employeeRequest);

    List<EmployeeDto> getAllEmployees ();

    EmployeeDto getEmployeeById (Integer id);

    EmployeeDto updateEmployee (Integer id, EmployeeRequest employeeRequest);

    String deleteEmployee (Integer id);

    EmployeeDto findEmployeeByEmail (String email);

    List <EmployeeDto> findEmployeeByHighSalary ();

    List <EmployeeDto> findEmployeedByHigherExperienced ();





}
