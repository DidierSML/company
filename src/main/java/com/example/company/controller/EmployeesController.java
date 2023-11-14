package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apiCompany")
public class EmployeesController {


    private final EmployeesService employeesService;

    @PostMapping("saveEmployee")
    @ResponseStatus(HttpStatus.OK)
    public Employee saveEmployee (@RequestBody Employee employee){
        return employeesService.saveEmployee(employee);
    }

    @GetMapping("getAllEmployees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees (){
        return  employeesService.getAllEmployees();
    }

    @GetMapping("findEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployyeById (Integer id){
        return employeesService.getEmployeeById(id);
    }

    @PutMapping("updateEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee (Integer id, Employee employee){
        return employeesService.updateEmployee(id, employee);
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteEmployeeById (Integer id){
        return employeesService.deleteEmployee(id);
    }
    @GetMapping("findEmployeeByEmail")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Employee>  findEmployeeByEmail (@RequestParam String email){
        return employeesService.findEmployeeByEmail(email);
    }

    @GetMapping("findEmployeeByHigherSalary")
    @ResponseStatus(HttpStatus.FOUND)
    public List <Employee> findEmployeeByHigherSalary (@RequestParam Double salary){
        return employeesService.findEmployeeByHighSalary(salary);
    }

    @GetMapping("findEmployeeByHigherExperience")
    @ResponseStatus(HttpStatus.FOUND)
    public List <Employee> findEmployeeByHigherExperience (@RequestParam Integer years){
        return employeesService.findEmployeedByHigherExperienced(years);
    }

}
