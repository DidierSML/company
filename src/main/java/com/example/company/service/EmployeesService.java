package com.example.company.service;

import com.example.company.model.Employee;
import com.example.company.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    //Save Employee
    public Employee saveEmployee(Employee employee){
        return employeesRepository.saveEmployee(employee);
    }

    //get All Employees
    public List<Employee> getAllEmployees (){
        return employeesRepository.getAllEmployees();
    }

    //get Employee By Id
    public Employee getEmployeeById (Integer id){
        return employeesRepository.getEmployeeById(id);
    }

    //update Employee
    public Employee updateEmployee (Integer id, Employee employee){
        return employeesRepository.updateEmployeeById(id,employee);
    }

    //delete Employee By Id
    public String deleteEmployee (Integer id){
        return employeesRepository.deleteEmployeeById(id);
    }

    //Find Employee By Email
    public List <Employee> findEmployeeByEmail (String email)   {
        return employeesRepository.findEmployeeByEmail(email);
    }

    //Find Employee By High Salary
    public List <Employee> findEmployeeByHighSalary (){
        return  employeesRepository.findByHigherSalary();
    }

    //Find By Higher Experienced
    public List <Employee> findEmployeedByHigherExperienced (){
        return employeesRepository.findByHigherExperience();
    }


}
