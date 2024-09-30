package com.faz.sadminpasajes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "tipo_persona", discriminatorType = DiscriminatorType.STRING)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotNull
    @NotBlank(message = "name can´t be empty value")
    private String nombre;
    @NotNull
    @NotBlank(message = "apellido can´t be empty value")
    private String apellido;
    @NotNull
    private int dni;

    @NotNull
    public int getDni() {
        return dni;
    }
}
