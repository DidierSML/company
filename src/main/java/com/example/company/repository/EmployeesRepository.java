package com.example.company.repository;

import com.example.company.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeesRepository {

    //Lista de empleados inicializada
    private final List<Employee> employeesList = new ArrayList<>();

    //Método obtener todos los empleados
    public List <Employee> getAllEmployees (){
        return employeesList;
    }

    //Método guardar empleado
    public Employee saveEmployee (Employee employee){

        Employee nuevoEmployee = new Employee();
        nuevoEmployee.setId(employee.getId());
        nuevoEmployee.setName(employee.getName());
        nuevoEmployee.setLastName(employee.getLastName());
        nuevoEmployee.setAge(employee.getAge());
        nuevoEmployee.setExperience(employee.getExperience());
        nuevoEmployee.setSalary(employee.getSalary());
        nuevoEmployee.setPhone(employee.getPhone());
        nuevoEmployee.setEmail(employee.getEmail());

        employeesList.add(nuevoEmployee);
        return employee;
    }

    //Método obtener empleado por Id
    public Optional <Employee> getEmployeeById (Integer id){
        for (int i = 0; i < employeesList.size(); i++){
            if(employeesList.get(i).getId() == id ){
                return Optional.of(employeesList.get(i));
            }
        }

        System.out.println("This -ID- does not belong to any Employee");
        return Optional.empty();
    }

    //Actualizar Empleado
    public Employee updateEmployeeById (Integer id, Employee updateEmployee){

        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                employeesList.set(i, updateEmployee);
                System.out.println("Successfully updated");
                return updateEmployee;  // Mover este retorno aquí
            }
        }
        System.out.println("This -ID- does not belong to any Employee");
        return null;
    }

    //Eliminar empleado
    public String deleteEmployeeById (Integer id){
        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getId() == id){
                employeesList.remove(i);
                return "Successful Deletion";
            }
        }
        return "Invalid ID";
    }

    //Listar Empleado por Email
    public Employee findEmployeeByEmail (String email){

        //List <Employee> encontradosByEmail = new ArrayList<>();

        for(int i = 0; i < employeesList.size(); i++){

            if (employeesList.get(i).getEmail().equalsIgnoreCase(email)){
                return employeesList.get(i);
               // encontradosByEmail.add(employeesList.get(i));
            }
        }
        System.out.println("This -Email- does not belong to any Employee");
        return null;
    }

    //Listar empleados con sueldo > 1000
    public List <Employee> findByHigherSalary (){

        double highSalary = 1000;

        List <Employee> higherSalary = new ArrayList<>();

        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getSalary() >= highSalary){
                higherSalary.add(employeesList.get(i));
            }
        }

        if (higherSalary.isEmpty()){
            System.out.println("None of the employees has a high salary");
        }

        return higherSalary;
    }

    //Listar Empleados con > 5 años de experiencia
    public List <Employee> findByHigherExperience (){

        int highYears = 5;

        List <Employee> experiencedPeople = new ArrayList<>();

        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getExperience() >= highYears){
                experiencedPeople.add(employeesList.get(i));
            }
        }

        if (experiencedPeople.isEmpty()){
            System.out.println("None of the employees has a high experience");
        }

        return experiencedPeople;
    }
}
