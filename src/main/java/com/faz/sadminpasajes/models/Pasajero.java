package com.faz.sadminpasajes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Pasajero extends Persona {

    @ManyToOne
    private Empresa empresaPasajero;

    public Pasajero(String nom,String ape, int dni){
        super(nom, ape, dni);
    }

    

}
