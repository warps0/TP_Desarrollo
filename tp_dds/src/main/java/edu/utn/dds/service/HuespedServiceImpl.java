package edu.utn.dds.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
        HuespedDTO huespedReturn = null;
    
        try{
            LocalDate trueDoB = LocalDate.parse(doB, formatter);
            Contacto trueContact = new Contacto();
            trueContact.setTelefono(telefono);
            trueContact.setDireccion(direccion);
            trueContact.setEmail(correo);

            Huesped huesped = repository.crearHuesped(dni, nombre, apellido, tipo_dni, nacionalidad, trueDoB, trueContact);

            if(huesped == null) throw new HuespedNoCreadoException();

            huespedReturn = new HuespedDTO(dni, nombre, apellido, tipo_dni, nacionalidad, correo, trueDoB, direccion);
        }
        catch(DateTimeParseException e){
            e.getMessage();  
            e.getStackTrace();
        }

        return huespedReturn;
    }

    @Override
    public HuespedDTO modificarHuesped(String id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, String doB, String telefono, String correo, String direccion) throws HuespedNoEncontradoException, IdInvalidoException {
        Long trueID = null;
        Huesped huesped = null;
        HuespedDTO huespedReturn = null;
        
        try{
            if(id != null && id != "")
                trueID = Long.parseLong(id);
            else
                trueID = null;

            if(trueID <= 0) throw new IdInvalidoException("El ID debe ser mayor a 0.");

            huesped = repository.modificarHuesped(trueID, dni, nombre, apellido, tipo_dni, nacionalidad);
            // VERIFICAR QUE NO EXISTAN 2 HUESPEDES CON EL MISMO Y TIPO DNI
            if(huesped == null) throw new HuespedNoEncontradoException();
            else {
                huespedReturn = new HuespedDTO(dni, nombre, apellido, tipo_dni, nacionalidad, correo, huesped.getDoB(), direccion);
            }
        }
        catch(NumberFormatException e){
            throw new IdInvalidoException("El ID debe ser un número.");
        }

        return huespedReturn;
    }

    @Override
    public void borrarHuesped(String id) throws HuespedNoEncontradoException, IdInvalidoException{
        Long trueID = null;
        Huesped huesped = null;

        try {
            if(id != null && id != "")
                trueID = Long.parseLong(id);
            else
                trueID = null;

            if(trueID <= 0) throw new IdInvalidoException("El ID debe ser mayor a 0.");
            
            huesped = repository.borrarHuesped(trueID);
            
            if(huesped == null) throw new HuespedNoEncontradoException();
        } catch(NumberFormatException e){
            throw new IdInvalidoException("El ID debe ser un número.");
        }
    }

    @Override
    public List<HuespedDTO> buscarHuesped(String id, String dni, String nombre, String apellido, String tipo_doc) throws HuespedNoEncontradoException, IdInvalidoException {
        Long trueID = null;
        List<HuespedDTO> huespedReturn = new ArrayList<>();

        try {
            if(id != null && id != "")
                trueID = Long.parseLong(id);
            else
                trueID = null;

            List<Huesped> huespedes = repository.buscarHuesped(trueID, dni, nombre, apellido, tipo_doc);

            if(huespedes == null) throw new HuespedNoEncontradoException();

            for(Huesped huesped : huespedes) {
                huespedReturn.add(
                    new HuespedDTO(
                        huesped.getDni(), 
                        huesped.getNombre(), 
                        huesped.getApellido(), 
                        huesped.getTipo_dni(), 
                        huesped.getNacionalidad(), 
                        huesped.getOcupacion(), 
                        huesped.getDoB(), 
                        huesped.getPos_f_iva()
                    )
                );
            }

        } catch(NumberFormatException e){
            throw new IdInvalidoException("El ID debe ser un número.");
        } 

        return huespedReturn;
    }

    @Override
    public void mostrarListadoHuespedes(String dni, String nombre, String apellido, String tipo_doc) throws HuespedNoEncontradoException {
        // Agregar tipo dni
        List<Huesped> huespedes = repository.buscarHuesped(null, dni, nombre, apellido, tipo_doc);

        if(huespedes == null) throw new HuespedNoEncontradoException();

        for(Huesped h : huespedes){
            System.out.print("Huesped ID: ");
            System.out.println(h.getId());

            System.out.print("Nombre: ");
            System.out.println(h.getNombre());

            System.out.print("Apellido: ");
            System.out.println(h.getApellido());

            System.out.print("DNI: ");
            System.out.println(h.getDni());

            System.out.print("Tipo DNI: ");
            System.out.println(h.getTipo_dni());
        }
    }
}
