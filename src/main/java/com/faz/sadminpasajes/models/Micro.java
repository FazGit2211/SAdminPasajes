package com.faz.sadminpasajes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Micro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank(message = "numero can´t be empty value")
    private String numero;

    @NotBlank(message = "linea can´t be empty value")
    private String linea;

    
    private int capacidad;

    @ManyToOne
    private Empresa empresaMicro;

    public Micro(){}

    public Micro(String numero, String linea, int capacidad) {
        this.numero = numero;
        this.linea = linea;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEmpresa(Empresa empresa){
        empresaMicro = empresa;
    }
}
