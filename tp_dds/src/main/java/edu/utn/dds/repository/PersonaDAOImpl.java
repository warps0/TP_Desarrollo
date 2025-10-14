package edu.utn.dds.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.utn.dds.model.Huesped;
import edu.utn.dds.model.Persona;

public final class PersonaDAOImpl implements PersonaDAO {
    private static PersonaDAOImpl SINGLETON_INSTANCE;

    private ObjectMapper mapper;

    String currentDirectory = System.getProperty("user.dir");

    private File jsonFile = new File(currentDirectory + "\\tp_dds\\src\\main\\resources\\huespedes.json");
    
    private PersonaDAOImpl() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public synchronized static PersonaDAOImpl getPersonaDAOInstance() {
        if(SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new PersonaDAOImpl();
        }

        return SINGLETON_INSTANCE;
    }

    @Override
    public Persona crearHuesped() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'crearHuesped'");
        this.getDataFromJson(mapper, jsonFile);

        return null;
    }

    @Override
    public void modificarHuesped(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarHuesped'");
    }

    @Override
    public void borrarHuesped(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarHuesped'");
    }

    @Override
    public void buscarHuesped(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuesped'");
    }

    @Override
    public void buscarHuespedPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorNombre'");
    }

    @Override
    public void buscarHuespedPorApellido(String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorApellido'");
    }

    @Override
    public void buscarHuespedPorDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHuespedPorDni'");
    }
    
    public void getDataFromJson(ObjectMapper mapper, File file){

        try{
            List<Huesped> huespedes = mapper.readValue(file, new TypeReference<List<Huesped>>(){});

            System.out.println("Total users read: " + huespedes.size());
            for (Huesped u : huespedes) {
                System.out.println(u.getNacionalidad());
            }
        }
        catch(IOException e){
            e.printStackTrace();
            e.getMessage();   
        }
    }
}
