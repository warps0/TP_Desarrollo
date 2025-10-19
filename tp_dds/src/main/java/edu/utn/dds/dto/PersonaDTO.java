package edu.utn.dds.dto;

import java.time.LocalDate;
import edu.utn.dds.model.Contacto;

public abstract class PersonaDTO{
    private String pos_f_iva;
    private String nacionalidad;
    private String ocupacion;
    private LocalDate doB;
     
    public PersonaDTO(){}
   
    public PersonaDTO(String nacionalidad, String ocupacion, LocalDate doB ,String pos_f_iva){
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.doB = doB;
        this.pos_f_iva = pos_f_iva;
    }
    

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public String getPos_f_iva() {
        return pos_f_iva;
    }

    public void setPos_f_iva(String pos_f_iva) {
        this.pos_f_iva = pos_f_iva;
    }
 
    @Override
    public String toString() {
        return "PersonaDTO{" + "nacionalidad=" + nacionalidad + ", ocupacion=" + ocupacion + ", doB=" + doB + '}';
    }
}