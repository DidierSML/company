package com.example.company.service;

import com.example.company.dto.EmployeeDto;
import com.example.company.dto.mapper.MapperEmployee;
import com.example.company.dto.request.EmployeeRequest;
import com.example.company.exceptions.NotFoundCustomException;
import com.example.company.model.Employee;
import com.example.company.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Employee employee = employeesRepository.getEmployeeById(id)
                .orElseThrow(() -> new NotFoundCustomException("Employee non-existent in our System"));


        return mapperEmployee.fromEntityToDto(employee);
    }



    //update Employee
    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeRequest employeeRequest) {

        //Obtener el empleado existente
        Optional<Employee> employee = employeesRepository.getEmployeeById(id);

        //Verificar si el empleado existe
        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();

            //Actualizar los campos del empleado con los valores Request
            existingEmployee.setName(employeeRequest.getName());
            existingEmployee.setLastName(employeeRequest.getLastName());
            existingEmployee.setAge(employeeRequest.getAge());
            existingEmployee.setSalary(employeeRequest.getSalary());
            existingEmployee.setPhone(employeeRequest.getPhone());
            existingEmployee.setExperience(employeeRequest.getExperience());
            existingEmployee.setEmail(employeeRequest.getEmail());

            //Actualizar el empleado en el Repositorio
            Employee updatedEmployee = employeesRepository.updateEmployeeById(id, existingEmployee);
            //Mapear el empleado entidad y retornar una respuesta DTO
            return mapperEmployee.fromEntityToDto(updatedEmployee);
        } else {
            //Si no existe el empleado, retornar esta excepción
            throw new NotFoundCustomException("This ID: " + id + " does not belong to any Employee");
        }
    }


    //delete Employee By -id- retornando String
    @Override
    public String deleteEmployee (Integer id){

        //Obtener un empleado o lanzar una excepción si no existe.
        employeesRepository.getEmployeeById(id)
                .orElseThrow(() -> new NotFoundCustomException("Employee -non- existent in our System"));

        //De encontrarse él (id) se elimina y se retorna la respuesta
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
    @Override
    public List <EmployeeDto> findEmployeeByHighSalary (){

        List <Employee> employeeList = employeesRepository.findByHigherSalary();

        return mapperEmployee.fromEntitiesToDtos(employeeList);
    }

    //Find By Higher Experienced
    @Override
    public List <EmployeeDto> findEmployeedByHigherExperienced (){

        List <Employee> employeeList = employeesRepository.findByHigherExperience();

        return mapperEmployee.fromEntitiesToDtos(employeeList);
    }


}

/*
    //delete Employee By id

    @Override
    public String deleteEmployee (Integer id){

        Employee employee = employeesRepository.getEmployeeById(id);

        if(employee != null){
            employeesRepository.deleteEmployeeById(id);
            return "The Employee has been deleted successfully removed";
        }else{
            return "This ID does not exist in our database";
        }

    }
 */