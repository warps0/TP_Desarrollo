package edu.utn.dds.model;

import java.time.LocalDate;

public abstract class Persona {
    private Long id;
    private String pos_f_iva;
    private String nacionalidad;
    private String ocupacion;
    private LocalDate DoB;
    private Contacto contacto;
    
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
        return DoB;
    }
    public void setDoB(LocalDate doB) {
        DoB = doB;
    }
    public Contacto getContacto() {
        return contacto;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }   
}