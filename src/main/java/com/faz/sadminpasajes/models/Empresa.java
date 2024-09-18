package com.faz.sadminpasajes.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank(message = "name can´t be empty value")
    private String nombre;

    @NotBlank(message = "cuil/cuit can´t be empty value")
    private String cuil_cuit;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Collection<Chofer> choferes;

    @OneToMany(mappedBy = "empresaMicro")
    private Collection<Micro> micros;

    @OneToMany(mappedBy = "empresaPasajero")
    private Collection<Pasajero> pasajeros;

    @OneToMany(mappedBy = "empresaPasaje")
    private Collection<Pasaje> pasajes;

    public Empresa() {
        choferes = new ArrayList<>();
        micros = new HashSet<>();
        pasajeros = new LinkedList<>();
        pasajes = new HashSet<>();
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

    public void addChofer(Chofer ch){
        if(!choferes.contains(ch)){
            choferes.add(ch);
            ch.setEmpresa(this);
        }
    }

    public void addMicro(Micro micro){
        if(!micros.contains(micro)){
            micros.add(micro);
            micro.setEmpresa(this);
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
            pasaje.setEmpresa(this);
        }
    }


    public Collection<Micro> getMicros(){
        return this.micros;
    }

    public Collection<Pasajero> getPasajeros(){
        return pasajeros;
    }
}
