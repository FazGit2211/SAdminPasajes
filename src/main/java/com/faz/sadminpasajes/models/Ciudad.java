package com.faz.sadminpasajes.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank
    private String nombre;

    @NotBlank
    private String provincia;

    @NotBlank
    private String localidad;

    
    private float distancia;

    public Ciudad(){}

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getProvincia(){
        return this.provincia;
    }

    public String getLocalidad(){
        return this.localidad;
    }

    public float getDistancia(){
        return this.distancia;
    }
}
