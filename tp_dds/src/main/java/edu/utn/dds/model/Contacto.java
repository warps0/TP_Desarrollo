package edu.utn.dds.model;

public class Contacto {
    // TODO: Ver si conviene trabajar con una lista de telefonos/emails o con una lista de contactos
    
    private Integer telefono;
    private String email;
    private String direccion;
    
    public Contacto(Integer telefono, String email, String direccion) {
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
}