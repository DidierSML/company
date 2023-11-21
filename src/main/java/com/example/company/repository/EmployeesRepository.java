package com.example.company.repository;

import com.example.company.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeesRepository {

    //Lista de empleados inicializada
    private List<Employee> employeesList = new ArrayList<>();

    //Metodo obtener todos los empleados
    public List <Employee> getAllEmployees (){
        return employeesList;
    }

    //Metodo guardar empleado
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

    //Metodo obtener empleado por Id
    public Employee getEmployeeById (Integer id){
        for (int i = 0; i < employeesList.size(); i++){
            if(employeesList.get(i).getId() == id ){
                return employeesList.get(i);
            }
        }

        System.out.println("Este ID no pertenece a ningun empleado");
        return null;
    }

    //Actutalizar Empleado
    public Employee updateEmployeeById (Integer id, Employee updateEmployee){

        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                employeesList.set(i, updateEmployee);
                System.out.println("Actualizacion Exitosa");
                return updateEmployee;  // Mover este retorno aquí
            }
        }
        System.out.println("Este ID no pertenece a ningun empleado");
        return null;
    }

    //Eliminar empleado
    public String deleteEmployeeById (Integer id){
        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getId() == id){
                employeesList.remove(i);
                return "The Employee has been successfully removed";
            }
        }
        return "This ID Does not exist in our data base";
    }

    //Listar Empleado por email
    public Employee findEmployeeByEmail (String email){

        //List <Employee> encontradosByEmail = new ArrayList<>();

        for(int i = 0; i < employeesList.size(); i++){

            if (employeesList.get(i).getEmail().equalsIgnoreCase(email)){
                return employeesList.get(i);
               // encontradosByEmail.add(employeesList.get(i));
            }
        }
        System.out.println("This Email doesn´t belong to any Employee");
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
