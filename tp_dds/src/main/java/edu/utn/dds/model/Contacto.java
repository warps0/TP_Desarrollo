package edu.utn.dds.model;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private List<Integer> telefono;
    private List<String> email;
    private String direccion;
    
    public Contacto(Integer telefono, String email, String direccion) {
        this.telefono = new ArrayList<>();
        this.email = new ArrayList<>();
        this.telefono.add(telefono);
        this.email.add(email);
        this.direccion = direccion;
    }

    public List<Integer> getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono.add(telefono);
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
}