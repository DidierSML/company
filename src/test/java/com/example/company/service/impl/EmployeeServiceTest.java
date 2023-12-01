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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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

    @DisplayName
            ("Simulacion que espera que se retorne la Lista de Empleados, segun la logica del metodo")

    @Test
    public void testGetAllEmployees (){

        //Insertando datos de prueba
        List<Employee> employeeList = new ArrayList<>();//Lista Creada tipo (Employee)

        Employee employee1 = new Employee(); //Employee 1 en la BD
        employee1.setId(3);
        employee1.setAge(29);
        employee1.setName("Larry");
        employee1.setLastName("Montoya");
        employee1.setPhone("1234567777");
        employee1.setEmail("larry@hotmail.com");
        employee1.setSalary(900);
        employee1.setExperience(6);
        employeeList.add(employee1); //Agregado a la Lista - employeeList

        Employee employee2 = new Employee(); //Employee 2 en la BD
        employee2.setId(4);
        employee2.setAge(33);
        employee2.setName("Bojan");
        employee2.setLastName("Reus");
        employee2.setPhone("1234567778");
        employee2.setEmail("bojan@gmail.com");
        employee2.setSalary(700);
        employee2.setExperience(4);
        employeeList.add(employee2); //Agregado a la Lista - employeeList

        //Cuando se invoque el método -getAllEmployees- retorne la lista -employeeList-
        when(employeesRepository.getAllEmployees()).thenReturn(employeeList);

        //Lista expectante que retornará los -employeeDto-
        List<EmployeeDto> employeeListDtoExpected = new ArrayList<>();

        //Datos de Prueba
        EmployeeDto employeeDto1 = new EmployeeDto(); //EmployeeDto 1 en la BD
        employeeDto1.setId(3);
        employeeDto1.setAge(29);
        employeeDto1.setName("Larry");
        employeeDto1.setLastName("Montoya");
        employeeDto1.setPhone("1234567777");
        employeeDto1.setEmail("larry@hotmail.com");
        employeeDto1.setSalary(900);
        employeeDto1.setExperience(6);
        employeeListDtoExpected.add(employeeDto1); //Agregado a la Lista - employeeListDtoExpected

        EmployeeDto employeeDto2 = new EmployeeDto(); //EmployeeDto 2 en la BD
        employeeDto2.setId(4);
        employeeDto2.setAge(33);
        employeeDto2.setName("Bojan");
        employeeDto2.setLastName("Reus");
        employeeDto2.setPhone("1234567778");
        employeeDto2.setEmail("bojan@gmail.com");
        employeeDto2.setSalary(700);
        employeeDto2.setExperience(4);
        employeeListDtoExpected.add(employeeDto2); //Agregado a la Lista - employeeListDtoExpected

        //Cuando se ejecute el mapeo reciba la lista -employeeList- y retorne la -lista expectante Dto-
        when(mapperEmployee.fromEntitiesToDtos(employeeList)).thenReturn(employeeListDtoExpected);

        //Ejecute el método que se está probando en el Servicio -getAllEmployees-
        List <EmployeeDto> result = employeesServiceImpl.getAllEmployees();

        //Verifica que el resultado sea igual en tamaño, tanto el de los -Dto de Prueba- como el de los -Dto result-
        assertEquals(employeeListDtoExpected.size(),result.size());

        //Comparar los valores individuales entre employeeList, employeeListDtoExpected y result
        for(int i = 0; i < employeeList.size(); i++){
            Employee employeeModel = employeeList.get(i);
            EmployeeDto employeeDtoModel = employeeListDtoExpected.get(i);
            EmployeeDto resultDto = result.get(i);

            //Compare igualdad en el índice -employeeModel- y el índice -employeeDtoModel-
            assertEquals(employeeModel.getId(), employeeDtoModel.getId());
            assertEquals(employeeModel.getName(), employeeDtoModel.getName());
            assertEquals(employeeModel.getLastName(), employeeDtoModel.getLastName());
            assertEquals(employeeModel.getAge(), employeeDtoModel.getAge());
            assertEquals(employeeModel.getEmail(), employeeDtoModel.getEmail());
            assertEquals(employeeModel.getSalary(), employeeDtoModel.getSalary());
            assertEquals(employeeModel.getExperience(), employeeDtoModel.getExperience());
            assertEquals(employeeModel.getPhone(), employeeDtoModel.getPhone());

            //Compare igualdad en el índice -employeeDtoModel- y el índice -resultDto-
            assertEquals(employeeDtoModel.getId(), resultDto.getId());
            assertEquals(employeeDtoModel.getName(), resultDto.getName());
            assertEquals(employeeDtoModel.getLastName(), resultDto.getLastName());
            assertEquals(employeeDtoModel.getAge(), resultDto.getAge());
            assertEquals(employeeDtoModel.getEmail(), resultDto.getEmail());
            assertEquals(employeeDtoModel.getSalary(), resultDto.getSalary());
            assertEquals(employeeDtoModel.getExperience(), resultDto.getExperience());
            assertEquals(employeeDtoModel.getPhone(), resultDto.getPhone());
        }

        System.out.println("Los valores de las listas (employeeList, employeeListDtoExpected y result) coinciden");

        verify(employeesRepository, times(1)).getAllEmployees();
        verify(mapperEmployee, times(1)).fromEntitiesToDtos(employeeList);
    }

}
