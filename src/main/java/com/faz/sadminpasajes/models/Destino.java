package com.faz.sadminpasajes.models;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private Date salida;

    private Date llegada;

    private String ciudadOrigen;

    private String ciudadDestino;


    public Destino(){}

    public Destino(Date fechaSalida, Date fechaLlegada, String ciudadOrigen, String ciudadDestino){
        this.salida = fechaSalida;
        this.llegada = fechaLlegada;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        
    }

    public int getId(){
        return id;
    }

    public Date getSalida(){
        return this.salida;
    }

    public Date getLlegada(){
        return this.llegada;
    }

    public String getCiudadOrigen(){
        return this.ciudadOrigen;
    }

    public String getCiudadDestino(){
        return this.ciudadDestino;
    }
}
