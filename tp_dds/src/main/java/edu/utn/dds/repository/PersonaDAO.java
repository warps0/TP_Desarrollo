package edu.utn.dds.repository;

import java.time.LocalDate;
import java.util.List;

import edu.utn.dds.model.Contacto;
import edu.utn.dds.model.Huesped;

public interface PersonaDAO {
    public Huesped crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, LocalDate doB, Contacto contacto);
    public Huesped modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad);
    public Huesped borrarHuesped(Long id);
    public List<Huesped> buscarHuesped(Long id, String dni, String nombre, String apellido);
}
