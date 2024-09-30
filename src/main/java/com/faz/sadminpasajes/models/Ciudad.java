package com.faz.sadminpasajes.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public String getLocalidad(){
        return this.localidad;
    }

    public float getDistancia(){
        return this.distancia;
    }

    public @NotBlank String getNombre() {
        return this.nombre;
    }
}
