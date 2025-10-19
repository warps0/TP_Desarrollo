package edu.utn.dds.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.utn.dds.model.Contacto;
import edu.utn.dds.model.Huesped;
import edu.utn.dds.model.Persona;

public final class PersonaDAOImpl implements PersonaDAO {
    private static PersonaDAOImpl SINGLETON_INSTANCE;

    private ObjectMapper mapper;

    private String currentDirectory = System.getProperty("user.dir");

    private File jsonFile = new File(currentDirectory + "\\tp_dds\\src\\main\\resources\\huespedes.json");
    
    private PersonaDAOImpl() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public synchronized static PersonaDAO getPersonaDAOInstance() {
        if(SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new PersonaDAOImpl();
        }

        return SINGLETON_INSTANCE;
    }

    @Override
    public Huesped crearHuesped(String dni, String nombre, String apellido, String tipo_dni, String nacionalidad, LocalDate doB, Contacto contacto) {
        List<Huesped> listaHuespedes = this.getDataFromJson();

        Long newId = listaHuespedes.getLast().getId() + 1;

        Huesped huesped = new Huesped(newId, dni, nombre, apellido, tipo_dni, nacionalidad, doB, contacto);
        
        listaHuespedes.add(huesped);

        this.setDataToJson(listaHuespedes);

        return huesped;
    }

    @Override
    public Huesped modificarHuesped(Long id, String dni, String nombre, String apellido, String tipo_dni, String nacionalidad) {
        Huesped huespedAModificar = buscarHuesped(id, null, null, null).getFirst();

        if(dni != null) huespedAModificar.setDni(dni);
        if(nombre != null) huespedAModificar.setNombre(nombre);
        if(apellido != null) huespedAModificar.setApellido(apellido);
        if(tipo_dni != null) huespedAModificar.setTipo_dni(tipo_dni);
        if(nacionalidad != null) huespedAModificar.setNacionalidad(nacionalidad);

        borrarHuesped(id);

        List<Huesped> listaHuespedes = getDataFromJson();
        listaHuespedes.add(huespedAModificar);

        setDataToJson(listaHuespedes);

        return huespedAModificar;
    }

    @Override
    public Huesped borrarHuesped(Long id) {
        Huesped huesped = this.buscarHuesped(id, null, null, null).getFirst();
        
        if(huesped != null) {
            List<Huesped> huespedes = this.getDataFromJson();
            huespedes.remove(huesped);
            this.setDataToJson(huespedes);
        }

        //Mover a capa superior
        //System.out.println("Huesped Eliminado exitosamente.");

        return huesped;
    }

    @Override
    public List<Huesped> buscarHuesped(Long id, String dni, String nombre, String apellido){
        List<Huesped> listaResultado = getDataFromJson();

        if(id != null){
            listaResultado = listaResultado.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList());
        }
        else {
            if(dni != null){
                listaResultado = listaResultado.stream().filter(p -> p.getDni().equals(dni)).collect(Collectors.toList());
            }
            if(nombre != null){
                listaResultado = listaResultado.stream().filter(p -> p.getNombre().equals(nombre)).collect(Collectors.toList());
            }
            if(apellido != null){
                listaResultado = listaResultado.stream().filter(p -> p.getApellido().equals(apellido)).collect(Collectors.toList());
            }
        }
        
        return listaResultado;
    }

    // Quedan a módo histórico
    /*
    @Override
    public Huesped buscarHuesped(Long id) {
        List<Huesped> huespedes = this.getDataFromJson();
        Huesped found = null;
        for (Huesped h : huespedes) {
            if(h.getId().equals(id)){
              found = h;  
              System.out.println("Huesped encontrado: " + h.getNombre() + " " + h.getApellido());
              } 
        }
        if (found == null) {
            System.out.println("No se encontro ningun huesped con el ID: " + id);
            //throw new HuespedNoEncontradoException()
        } else {
          System.out.println(found);
        }
        return found;
    }

    @Override
    public List<Huesped> buscarHuespedPorNombre(String nombre) {
        List<Huesped> huespedes = this.getDataFromJson();
        List<Huesped> foundList = new ArrayList<>();
        for (Huesped h : huespedes) {
            if(h.getNombre().equalsIgnoreCase(nombre)){
              foundList.add(h); 
              } 
        }
        if (foundList.isEmpty()) {
            System.out.println("No se encontro ningun huesped con el nombre: " + nombre);
        } else {
          System.out.println("Huespedes encontrados con el nombre " + nombre + ":");
          for (Huesped h : foundList) {
            System.out.println(h.getId() + " " + h.getNombre() + " " + h.getApellido());
          }
        }

        return foundList;
    }

    @Override
    public List<Huesped> buscarHuespedPorApellido(String apellido) {
        List<Huesped> huespedes = this.getDataFromJson();
        List<Huesped> foundList = new ArrayList<>();
        for (Huesped h : huespedes) {
            if(h.getApellido().equalsIgnoreCase(apellido)){
              foundList.add(h);  
              } 
        }
        if (foundList.isEmpty()) {
            System.out.println("No se encontro ningun huesped con el apellido: " + apellido);
        } else {
          System.out.println("Huespedes encontrados con el apellido " + apellido + ":");
          for (Huesped h : foundList) {
            System.out.println(h.getId() + " " + h.getNombre() + " " + h.getApellido());
          }
        }

        return foundList;
    }

    @Override
    public Huesped buscarHuespedPorDni(String dni) {
        Huesped found = null;
        List<Huesped> huespedes = this.getDataFromJson();
        for (Huesped h : huespedes) {
            if(h.getDni().equals(dni)){
                found = h;  
                //System.out.println("Huesped encontrado: " + h.getNombre() + " " + h.getApellido());
                break;
            } 
        }
        if (found == null) {
            System.out.println("No se encontro ningun huesped con el DNI: " + dni);
        } else {
            System.out.println("Huesped encontrado: " + found.getNombre() + " " + found.getApellido());
        }
        return found;
    }
    */

    // File handler
    private void setDataToJson(List<Huesped> huespedes) {
        try {
            mapper.writeValue(jsonFile ,huespedes);
        }
        catch(IOException e) {
            e.printStackTrace();
            e.getMessage();  
        }
    }

    private List<Huesped> getDataFromJson(){
        List<Huesped> huespedes = new ArrayList<>();

        try{
            mapper.readValue(jsonFile, new TypeReference<List<Huesped>>(){});
        }
        catch(IOException e){
            e.printStackTrace();
            e.getMessage();   
        }
        
        return huespedes;
    }
}