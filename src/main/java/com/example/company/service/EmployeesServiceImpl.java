package com.example.company.service;

import com.example.company.dto.EmployeeDto;
import com.example.company.dto.mapper.MapperEmployee;
import com.example.company.dto.request.EmployeeRequest;
import com.example.company.model.Employee;
import com.example.company.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;
    private final MapperEmployee mapperEmployee;

    //Save Employee
    @Override
    public EmployeeDto saveEmployee(EmployeeRequest employeeRequest){

        Employee employee = mapperEmployee.fromRequestToEntity(employeeRequest);

        Employee newEmployee = employeesRepository.saveEmployee(employee);

        return mapperEmployee.fromEntityToDto(newEmployee);
    }

    //get All Employees
    @Override
    public List<EmployeeDto> getAllEmployees (){

        List <Employee> content = employeesRepository.getAllEmployees();

        return mapperEmployee.fromEntitiesToDtos(content);
    }

    //get Employee By Id
    @Override
    public EmployeeDto getEmployeeById (Integer id){

        Employee employee = employeesRepository.getEmployeeById(id);

        return mapperEmployee.fromEntityToDto(employee);


    }

    //update Employee
    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeRequest employeeRequest) {

        Employee employee = employeesRepository.getEmployeeById(id);

        employee.setLastName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setAge(employeeRequest.getAge());
        employee.setSalary(employeeRequest.getSalary());
        employee.setPhone(employeeRequest.getPhone());
        employee.setExperience(employeeRequest.getExperience());
        employee.setEmail(employeeRequest.getEmail());

        Employee updatedEmployee = employeesRepository.saveEmployee(employee);

        return mapperEmployee.fromEntityToDto(updatedEmployee);
    }



    //delete Employee By Id
    @Override
    public String deleteEmployee (Integer id){

        employeesRepository.getEmployeeById(id);

        employeesRepository.deleteEmployeeById(id);

        return "The Employee has been successfully removed";

    }

    //Find Employee By Email
    @Override
    public EmployeeDto findEmployeeByEmail (String email)   {

        Employee employee = employeesRepository.findEmployeeByEmail(email);

        return mapperEmployee.fromEntityToDto(employee);
    }

    //Find Employee By High Salary
    public List <EmployeeDto> findEmployeeByHighSalary (){

        List <Employee> employeeList = employeesRepository.findByHigherSalary();

        return mapperEmployee.fromEntitiesToDtos(employeeList);
    }

    //Find By Higher Experienced
    public List <EmployeeDto> findEmployeedByHigherExperienced (){

        List <Employee> employeeList = employeesRepository.findByHigherExperience();

        return mapperEmployee.fromEntitiesToDtos(employeeList);
    }


}
