package com.example.company.dto.mapper;

import com.example.company.dto.EmployeeDto;
import com.example.company.dto.request.EmployeeRequest;
import com.example.company.dto.response.EmployeeResponse;
import com.example.company.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperEmployee {

    MapperEmployee MAPPER_EMPLOYEE = Mappers.getMapper(MapperEmployee.class);

    Employee fromRequestToEmployee (EmployeeRequest employeeRequest);

    EmployeeDto fromEntityToDto (Employee employee);

    EmployeeResponse fromDtoToResponse (EmployeeDto employeeDto);

    List <EmployeeDto> fromEntitiesToDtos (List <Employee> employeeList);

    List <EmployeeResponse> fromDtosToResponses (List <EmployeeDto> employeeDtoList);


}
