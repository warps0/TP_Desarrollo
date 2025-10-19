package edu.utn.dds.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import edu.utn.dds.dto.HuespedDTO;
import edu.utn.dds.exception.HuespedNoCreadoException;
import edu.utn.dds.exception.HuespedNoEncontradoException;
import edu.utn.dds.exception.IdInvalidoException;
import edu.utn.dds.model.Contacto;
import edu.utn.dds.model.Huesped;
import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;

public class HuespedServiceImpl implements HuespedService {
    private PersonaDAO repository = PersonaDAOImpl.getPersonaDAOInstance(); 

    @Override
    public HuespedDTO crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, String doB, String telefono, String correo, String direccion) throws HuespedNoCreadoException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
        try{
            LocalDate trueDoB = LocalDate.parse(doB, formatter);
            Contacto trueContact = new Contacto();
            trueContact.setTelefono(telefono);
            trueContact.setDireccion(direccion);
            trueContact.setEmail(correo);

            Huesped huesped = repository.crearHuesped(dni, nombre, apellido, tipo_dni, nacionalidad, trueDoB, trueContact);

            if(huesped == null) throw new HuespedNoCreadoException();
        }
        catch(DateTimeParseException e){
            e.getMessage();  
            e.getStackTrace();
        }

        // FIX RETURN DTO
        return null;
    }

    @Override
    public HuespedDTO modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, String doB, String telefono, String correo, String direccion) throws HuespedNoEncontradoException, IdInvalidoException {
        if(id <= 0) throw new IdInvalidoException();
        else{
            Huesped huesped = repository.modificarHuesped(id, dni, nombre, apellido, tipo_dni, nacionalidad);

            if(huesped == null) throw new HuespedNoEncontradoException();
        }

        // FIX RETURN DTO
        return null;
    }

    @Override
    public void borrarHuesped(Long id) throws HuespedNoEncontradoException, IdInvalidoException{
        if(id <= 0) throw new IdInvalidoException();
        else{
            Huesped huesped = repository.borrarHuesped(id);

            if(huesped == null) throw new HuespedNoEncontradoException();
        }
    }

    @Override
    public List<HuespedDTO> buscarHuesped(Long id, String dni, String nombre, String apellido) throws HuespedNoEncontradoException, IdInvalidoException{
        if(id <= 0) throw new IdInvalidoException();

        // FIX RETURN DTO
        return null;
    }
}
