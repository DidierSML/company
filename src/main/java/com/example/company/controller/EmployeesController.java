package com.example.company.controller;

import com.example.company.dto.mapper.MapperEmployee;
import com.example.company.dto.request.EmployeeRequest;
import com.example.company.dto.response.EmployeeResponse;
import com.example.company.model.Employee;
import com.example.company.service.EmployeesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apiCompany")
public class EmployeesController {


    private final EmployeesServiceImpl employeesServiceImpl;
    private final MapperEmployee mapperEmployee;

    @PostMapping("saveEmployee")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse saveEmployee (@RequestBody EmployeeRequest employeeRequest){

        return mapperEmployee.fromDtoToResponse(employeesServiceImpl.saveEmployee(employeeRequest));

    }

    @GetMapping("getAllEmployees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees (){

        return mapperEmployee.fromDtosToResponses(employeesServiceImpl.getAllEmployees());

    }

    @GetMapping("getEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployeeById (@PathVariable Integer id){

        return mapperEmployee.fromDtoToResponse(employeesServiceImpl.getEmployeeById(id));

    }

    @PutMapping("updateEmployeeById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse updateEmployee (@PathVariable Integer id,@RequestBody EmployeeRequest employeeRequest){

        return mapperEmployee.fromDtoToResponse(employeesServiceImpl.updateEmployee(id, employeeRequest));

    }

    @DeleteMapping("deleteEmployeeById/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteEmployeeById (@PathVariable Integer id){

        return employeesServiceImpl.deleteEmployee(id);

    }
    @GetMapping("findEmployeeByEmail")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeResponse  findEmployeeByEmail (@RequestParam String email){

        return mapperEmployee.fromDtoToResponse(employeesServiceImpl.findEmployeeByEmail(email));

    }

    @GetMapping("findEmployeeByHigherSalary")
    @ResponseStatus(HttpStatus.FOUND)
    public List <EmployeeResponse> findEmployeeByHigherSalary (){

        return mapperEmployee.fromDtosToResponses(employeesServiceImpl.findEmployeeByHighSalary());
    }

    @GetMapping("findEmployeeByHigherExperience")
    @ResponseStatus(HttpStatus.FOUND)
    public List <EmployeeResponse> findEmployeeByHigherExperience (){

        return mapperEmployee.fromDtosToResponses(employeesServiceImpl.findEmployeedByHigherExperienced());
    }

}
