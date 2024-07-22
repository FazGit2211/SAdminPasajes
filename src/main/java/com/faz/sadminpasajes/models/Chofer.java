package com.faz.sadminpasajes.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Chofer extends Persona {
    @NotNull
    @NotBlank(message = "licencia no puede estar vacio")
    private String licencia;

    public Chofer() {
        super();
    }

    public Chofer(String nom,String ape,int dni,String licencia) {
        super(nom,ape,dni);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    private void setLicencia(String licencia) {
        this.licencia = licencia;
    }
}
