package com.faz.sadminpasajes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public int getId() {
        return id;
    }

    public @NotBlank(message = "numero can´t be empty value") String getNumero() {
        return numero;
    }
}
