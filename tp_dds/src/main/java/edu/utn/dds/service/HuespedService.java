package edu.utn.dds.service;

import java.util.List;

import edu.utn.dds.dto.HuespedDTO;
import edu.utn.dds.exception.*;

public interface HuespedService {
    public HuespedDTO crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, String doB, String telefono, String correo, String direccion) throws HuespedNoCreadoException, CredencialesExistentes;
    public HuespedDTO modificarHuesped(String id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, String doB, String telefono, String correo, String direccion) throws HuespedNoEncontradoException, IdInvalidoException, CredencialesExistentes;
    public void borrarHuesped(String id) throws HuespedNoEncontradoException, IdInvalidoException;
    public List<HuespedDTO> buscarHuesped(String id, String dni, String nombre, String apellido, String tipo_doc) throws HuespedNoEncontradoException, IdInvalidoException;

    public void mostrarListadoHuespedes(String dni, String nombre, String apellido, String tipo_doc) throws HuespedNoEncontradoException;
}
