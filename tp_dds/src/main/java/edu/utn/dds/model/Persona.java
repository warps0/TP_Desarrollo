package edu.utn.dds.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Persona {
    private Long id;
    private String pos_f_iva;
    private String nacionalidad;
    private String ocupacion;
    private LocalDate doB;
    private Contacto contacto;
    
    public Persona(){}
    
    public Persona(Long id, LocalDate dob, Contacto contacto){
        this.id = id;
        this.doB = dob;
        this.contacto = contacto;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPos_f_iva() {
        return pos_f_iva;
    }
    public void setPos_f_iva(String pos_f_iva) {
        this.pos_f_iva = pos_f_iva;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public LocalDate getDoB() {
        return doB;
    }
    public void setDoB(LocalDate fecha) {
        this.doB = fecha;
    }
    public Contacto getContacto() {
        return contacto;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}