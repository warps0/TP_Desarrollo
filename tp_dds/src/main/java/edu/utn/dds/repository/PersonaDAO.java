package edu.utn.dds.repository;

import edu.utn.dds.model.Persona;

public interface PersonaDAO {
    public Persona crearHuesped();
    public void modificarHuesped(Long id);
    public void borrarHuesped(Long id);
    public void buscarHuesped(Long id);
    public void buscarHuespedPorNombre(String nombre);
    public void buscarHuespedPorApellido(String apellido);
    public void buscarHuespedPorDni(String dni);
}
