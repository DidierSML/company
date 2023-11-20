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

    @GetMapping("getEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById (@PathVariable Integer id){
        return employeesService.getEmployeeById(id);
    }

    @PutMapping("updateEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee (@PathVariable Integer id,@RequestBody Employee employee){
        return employeesService.updateEmployee(id, employee);
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteEmployeeById (@PathVariable Integer id){
        return employeesService.deleteEmployee(id);
    }
    @GetMapping("findEmployeeByEmail")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Employee>  findEmployeeByEmail (@RequestParam String email){
        return employeesService.findEmployeeByEmail(email);
    }

    @GetMapping("findEmployeeByHigherSalary")
    @ResponseStatus(HttpStatus.FOUND)
    public List <Employee> findEmployeeByHigherSalary (){
        return employeesService.findEmployeeByHighSalary();
    }

    @GetMapping("findEmployeeByHigherExperience")
    @ResponseStatus(HttpStatus.FOUND)
    public List <Employee> findEmployeeByHigherExperience (){
        return employeesService.findEmployeedByHigherExperienced();
    }

}
