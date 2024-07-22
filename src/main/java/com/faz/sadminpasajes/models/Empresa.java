package com.faz.sadminpasajes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Basic
    @NotNull
    @NotBlank(message = "name can´t be empty value")
    private String nombre;

    @NotNull
    @NotBlank(message = "cuil/cuit can´t be empty value")
    private String cuil_cuit;

    public Empresa() {
    }

    public Empresa(String nombre, String cuil_cuit) {
        this.nombre = nombre;
        this.cuil_cuit = cuil_cuit;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil_cuit() {
        return cuil_cuit;
    }

    public void setCuil_cuit(String cuil_cuit) {
        this.cuil_cuit = cuil_cuit;
    }

}
