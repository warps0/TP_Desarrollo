package edu.utn.dds.exception;

public class CredencialesExistentes extends Exception {
    public CredencialesExistentes(){
        super("Ya se encuentra un huesped cargado con ese TIPO y NRO de documento.");
    }
}
