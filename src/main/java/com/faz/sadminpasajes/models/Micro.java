package com.faz.sadminpasajes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Micro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Basic
    @NotNull
    @NotBlank(message = "numero can´t be empty value")
    private String numero;

    @NotNull
    @NotBlank(message = "linea can´t be empty value")
    private String linea;

    @NotNull
    @NotBlank(message = "capacidad can´t be empty value")
    private int capacidad;


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
}
