package edu.utn.dds.dto;

import java.time.LocalDate;

public class HuespedDTO extends PersonaDTO{
    private String dni;
    private String nombre;
    private String apellido;
    private String tipo_dni;

    public HuespedDTO() {}
    
    public HuespedDTO(String dni, String nombre, String apellido, String tipo_dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dni = tipo_dni;
    }
    
    public HuespedDTO(String dni, String nombre, String apellido, String tipo_dni,String nacionalidad, String ocupacion, LocalDate doB, String pos_f_iva) {
        super(nacionalidad,ocupacion,doB,pos_f_iva);
        
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_dni = tipo_dni;
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

    @Override
    public String toString() {
        return "HuespedDTO{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_dni=" + tipo_dni + ", "+ super.toString().substring(11);
    }
}