package edu.utn.dds.model;

import java.time.LocalDate;

public class Huesped extends Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private String tipo_dni;
    
    public Huesped(){
        super();
    };

    public Huesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, LocalDate doB, Contacto contacto) {
        super(id, doB, contacto);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dni = tipo_dni;
        this.setNacionalidad(nacionalidad);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_dni() {
        return tipo_dni;
    }

    public void setTipo_dni(String tipo_dni) {
        this.tipo_dni = tipo_dni;
    }
}
