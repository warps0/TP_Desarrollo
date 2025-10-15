package edu.utn.dds.service;

import java.util.List;

import edu.utn.dds.dto.HuespedDTO;
import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;

public class HuespedServiceImpl implements HuespedService {
    private PersonaDAO repository = PersonaDAOImpl.getPersonaDAOInstance(); 

    @Override
    public HuespedDTO crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearHuesped'");
    }

    @Override
    public void modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarHuesped'");
    }

    @Override
    public void borrarHuesped(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarHuesped'");
    }

    @Override
    public HuespedDTO buscarHuesped(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuesped'");
    }

    @Override
    public List<HuespedDTO> buscarHuespedPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorNombre'");
    }

    @Override
    public List<HuespedDTO> buscarHuespedPorApellido(String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorApellido'");
    }

    @Override
    public HuespedDTO buscarHuespedPorDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorDni'");
    }

    @Override
    public List<HuespedDTO> pruebaLambda(Long id, String dni, String nombre, String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pruebaLambda'");
    }

}
