package edu.utn.dds.repository;

import java.util.List;

import edu.utn.dds.model.Huesped;
import edu.utn.dds.model.Persona;

public interface PersonaDAO {
    public Persona crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad);
    public void modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad);
    public void borrarHuesped(Long id);
    public Huesped buscarHuesped(Long id);
    public List<Huesped> buscarHuespedPorNombre(String nombre);
    public List<Huesped> buscarHuespedPorApellido(String apellido);
    public Huesped buscarHuespedPorDni(String dni);
    public List<Huesped> pruebaLambda(Long id, String dni, String nombre, String apellido);
}
