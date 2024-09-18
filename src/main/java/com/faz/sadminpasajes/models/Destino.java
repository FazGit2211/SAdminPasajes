package com.faz.sadminpasajes.models;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private Date salida;

    private Date llegada;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    @OneToOne(mappedBy = "destino")
    private Pasaje pasaje;


    public Destino(){}


    public int getId(){
        return id;
    }

    public Date getSalida(){
        return this.salida;
    }

    public Date getLlegada(){
        return this.llegada;
    }

    public Ciudad getCiudadOrigen(){
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino(){
        return ciudadDestino;
    }


}
