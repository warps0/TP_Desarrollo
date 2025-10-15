package edu.utn.dds.service;

import java.util.List;

import edu.utn.dds.dto.HuespedDTO;

public interface HuespedService {
    public HuespedDTO crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad); // Throws IdInvalidoException
    public void modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad); // Throws HuespedNoEncontradoException, IdInvalidoException
    public void borrarHuesped(Long id); // Throws HuespedNoEncontradoException, IdInvalidoException
    public HuespedDTO buscarHuesped(Long id); // Throws HuespedNoEncontradoException, IdInvalidoException
    public List<HuespedDTO> buscarHuespedPorNombre(String nombre); // Throws HuespedNoEncontradoException
    public List<HuespedDTO> buscarHuespedPorApellido(String apellido); // Throws HuespedNoEncontradoException
    public HuespedDTO buscarHuespedPorDni(String dni); // Throws HuespedNoEncontradoException
    public List<HuespedDTO> pruebaLambda(Long id, String dni, String nombre, String apellido);
}
