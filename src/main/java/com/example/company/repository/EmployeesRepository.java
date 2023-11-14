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

        for(int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getId() == id){
                employeesList.set(i, updateEmployee);
                System.out.println("Actualizacion Exitosa");
            }
            return updateEmployee;
        }
        System.out.println("Este ID no pertenece a ningun empleado");
        return null;
    }

    //Eliminar empleado
    public String deleteEmployeeById (Integer id){
        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getId() == id){
                employeesList.remove(i);
                return "Empleado eliminado de la Base de Datos";
            }
        }
        return "Este ID no pertenece a ningun empleado";
    }

    //Listar Empleado por email
    public List <Employee> findEmployeeByEmail (String email){

        List <Employee> encontradosByEmail = new ArrayList<>();

        for(int i = 0; i < employeesList.size(); i++){

            if (employeesList.get(i).getEmail().equalsIgnoreCase(email)){

                encontradosByEmail.add(employeesList.get(i));
            }
        }
        return encontradosByEmail;
    }

    //Listar empleados con sueldo > 1000
    public List <Employee> findByHigherSalary (double sueldo){

        List <Employee> higherSalary = new ArrayList<>();

        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getSalary() >= sueldo){
                higherSalary.add(employeesList.get(i));
            }
        }
        return higherSalary;
    }

    //Listar Empleados con > 5 años de experiencia
    public List <Employee> findByHigherExperience (int experiencia){

        List <Employee> experiencedPeople = new ArrayList<>();

        for (int i = 0; i < employeesList.size(); i++){
            if (employeesList.get(i).getExperience() >= experiencia){
                experiencedPeople.add(employeesList.get(i));
            }
        }
        return experiencedPeople;
    }
}
