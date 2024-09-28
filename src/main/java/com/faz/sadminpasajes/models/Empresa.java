package com.faz.sadminpasajes.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank(message = "name can´t be empty value")
    private String nombre;

    @NotBlank(message = "cuil/cuit can´t be empty value")
    private String cuil_cuit;

    @OneToMany
    private Collection<Chofer> choferes;

    @OneToMany
    private Collection<Micro> micros;

    @OneToMany
    private Collection<Pasajero> pasajeros;

    @OneToMany
    private Collection<Pasaje> pasajes;

    public Empresa() {
        choferes = new ArrayList<>();
        micros = new HashSet<>();
        pasajeros = new LinkedList<>();
        pasajes = new HashSet<>();
    }


    public void addChofer(Chofer ch){
        if(!choferes.contains(ch)){
            choferes.add(ch);
        }
    }

    public void addMicro(Micro micro){
        if(!micros.contains(micro)){
            micros.add(micro);
        }
    }

    public void deleteChofer(Chofer ch){
        if(choferes.contains(ch)){
            choferes.remove(ch);
        }
    }

    public void updateValues(Empresa empresaUpdate){
        setNombre(empresaUpdate.getNombre());
        setCuil_cuit(empresaUpdate.getCuil_cuit());
    }

    public void addPasaje(Pasaje pasaje){
        if(!pasajes.contains(pasaje)){
            pasajes.add(pasaje);
        }
    }


    public Collection<Micro> getMicros(){
        return this.micros;
    }

    public Collection<Pasajero> getPasajeros(){
        return pasajeros;
    }
}
