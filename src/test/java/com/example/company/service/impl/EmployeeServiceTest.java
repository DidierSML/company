package com.example.company.service.impl;

import com.example.company.dto.EmployeeDto;
import com.example.company.dto.mapper.MapperEmployee;
import com.example.company.dto.request.EmployeeRequest;
import com.example.company.model.Employee;
import com.example.company.repository.EmployeesRepository;
import com.example.company.service.EmployeesServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)//Indicamos que vamos a usar Mockito en la prueba Unitaria
class EmployeeServiceTest {

    @Mock//Simulación de Dependencia involucrada en el Testeo
    private EmployeesRepository employeesRepository;

    @Mock //Simulación de Dependencia involucrada en el Testeo
    private MapperEmployee mapperEmployee;

    /*Con esta @ nuestra (C) EmployeeServiceImpl recibirá los (Mocks) anteriores
      para el Testeo; de esta forma, cuando se llamen los métodos del servicio se
      usarán estos simuladores y no las dependencias reales
     */
    @InjectMocks
    private EmployeesServiceImpl employeesServiceImpl;

    @DisplayName
            ("Simulacion que espera que un Employee sea guardado, segun la logica del metodo")
    @Test
    public void testSaveEmployee_Successfully(){

        EmployeeRequest employeeRequest = new EmployeeRequest();

        employeeRequest.setId(2);
        employeeRequest.setAge(19);
        employeeRequest.setName("Jenny");
        employeeRequest.setLastName("Perez");
        employeeRequest.setPhone("1234567898");
        employeeRequest.setEmail("jenny@hotmail.com");
        employeeRequest.setSalary(800);
        employeeRequest.setExperience(4);

        Employee employee = new Employee();

        employee.setId(2);
        employee.setAge(19);
        employee.setName("Jenny");
        employee.setLastName("Perez");
        employee.setPhone("1234567898");
        employee.setEmail("jenny@hotmail.com");
        employee.setSalary(800);
        employee.setExperience(4);

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(2);
        employeeDto.setAge(19);
        employeeDto.setName("Jenny");
        employeeDto.setLastName("Perez");
        employeeDto.setPhone("1234567898");
        employeeDto.setEmail("jenny@hotmail.com");
        employeeDto.setSalary(800);
        employeeDto.setExperience(4);

        //Configurando Comportamiento de los Mocks
        when(mapperEmployee.fromRequestToEntity(employeeRequest)).thenReturn(employee);
        when(employeesRepository.saveEmployee(employee)).thenReturn(employee);
        when(mapperEmployee.fromEntityToDto(employee)).thenReturn(employeeDto);

        //Ejecutando el Método que se está probando (savEmployee)
        EmployeeDto result = employeesServiceImpl.saveEmployee(employeeRequest);
        System.out.println("Employee saved successfully");

        //Verificando que el objeto (Dto) resultante tenga el mismo "name" e "email" que el objeto (Request)
        assertEquals(employeeRequest.getName(), result.getName());
        assertEquals(employeeRequest.getEmail(), result.getEmail());

        System.out.println("Tanto el Objeto Request como el Objeto Dto coinciden");

        //Verificando si el resultado es (null), o si cumple con lo esperado.
        assertNotNull(result);
        System.out.println("El resultado o contenido No es null");

        //Verificando Interacciones con las dependencias(mocks) - N de llamadas post ejecución método de prueba
        Mockito.verify(mapperEmployee, times (1)).fromRequestToEntity(employeeRequest);
        Mockito.verify(employeesRepository,times(1)).saveEmployee(employee);
        Mockito.verify(mapperEmployee, times(1)).fromEntityToDto(employee);

    }

}
