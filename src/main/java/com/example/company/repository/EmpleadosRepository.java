package com.example.company.repository;

import com.example.company.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosRepository {

    //Lista de empleados inicializada
    private List<Empleado> empleadosList = new ArrayList<>();

    //Metodo obtener todos los empleados
    public List <Empleado> getAllEmployees (){
        return empleadosList;
    }

    //Metodo guardar empleado
    public Empleado saveEmpleado (Empleado empleado){

        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setId(empleado.getId());
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellido(empleado.getApellido());
        nuevoEmpleado.setEdad(empleado.getEdad());
        nuevoEmpleado.setExperiencia(empleado.getExperiencia());
        nuevoEmpleado.setSueldo(empleado.getSueldo());
        nuevoEmpleado.setTelefono(empleado.getTelefono());
        nuevoEmpleado.setEmail(empleado.getEmail());

        empleadosList.add(nuevoEmpleado);
        return empleado;
    }

    //Metodo obtener empleado por Id
    public Empleado getEmpleadoById (Integer id){
        for (int i = 0; i < empleadosList.size(); i++){
            if(empleadosList.get(i).getId() == id ){
                return empleadosList.get(i);
            }
        }

        System.out.println("Este ID no pertenece a ningun empleado");
        return null;
    }

    //Actutalizar Empleado
    public Empleado updateEmpleadoById (Integer id, Empleado updateEmpleado){

        for(int i = 0; i < empleadosList.size(); i++){
            if (empleadosList.get(i).getId() == id){
                empleadosList.set(i, updateEmpleado);
                System.out.println("Actualizacion Exitosa");
            }
            return updateEmpleado;
        }
        System.out.println("Este ID no pertenece a ningun empleado");
        return null;
    }

    //Eliminar empleado
    public String deleteEmpleadoById (Integer id){
        for (int i = 0; i < empleadosList.size(); i++){
            if (empleadosList.get(i).getId() == id){
                empleadosList.remove(i);
                return "Empleado eliminado de la Base de Datos";
            }
        }
        return "Este ID no pertenece a ningun empleado";
    }

    //Listar Empleado por email
    public List <Empleado> findEmpleadoByEmail (String email){

        List <Empleado> encontradosByEmail = new ArrayList<>();

        for(int i = 0; i < empleadosList.size(); i++){

            if (empleadosList.get(i).getEmail() == email){

                encontradosByEmail.add(empleadosList.get(i));
            }
        }
        return encontradosByEmail;
    }

    //Listar empleados con sueldo > 1000
    public List <Empleado> findBySueldoMayor (double sueldo){

        List <Empleado> encontradosSueldoMayor = new ArrayList<>();

        for (int i = 0; i < empleadosList.size(); i++){
            if (empleadosList.get(i).getSueldo() >= sueldo){
                encontradosSueldoMayor.add(empleadosList.get(i));
            }
        }
        return encontradosSueldoMayor;
    }

    //Listar Empleados con > 5 años de experiencia
    public List <Empleado> findByMayorExperiencia (int experiencia){

        List <Empleado> experimentados = new ArrayList<>();

        for (int i = 0; i < empleadosList.size(); i++){
            if (empleadosList.get(i).getExperiencia() >= experiencia){
                experimentados.add(empleadosList.get(i));
            }
        }
        return experimentados;
    }
}
