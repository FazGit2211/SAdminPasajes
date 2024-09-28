package com.faz.sadminpasajes.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Chofer extends Persona {
    
    @NotBlank(message = "licencia no puede estar vacio")
    private String licencia;

    public void setLicencia(String licencia){
        this.licencia = licencia;
    }

    public String getLicencia(){
        return this.licencia;
    }
 
}
