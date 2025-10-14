package edu.utn.dds;

import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;

public class Main {
    public static void main(String[] args) {
        
        PersonaDAO repo = PersonaDAOImpl.getPersonaDAOInstance();

        repo.crearHuesped();        
    }
}