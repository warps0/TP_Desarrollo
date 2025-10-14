package edu.utn.dds.model;

public class Contacto {
    // TODO: tratar telefono/email como colecciones
    private String telefono;
    private String email;
    private String direccion;
    
    public Contacto(){};

    public Contacto(String telefono, String email, String direccion) {
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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