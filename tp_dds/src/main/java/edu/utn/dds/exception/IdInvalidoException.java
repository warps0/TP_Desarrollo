package edu.utn.dds.exception;

public class IdInvalidoException extends Exception {
    public IdInvalidoException(){
        super("ID Inválido, ingrese un ID > 0.");
    }
}
