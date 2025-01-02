package com.faz.sadminpasajes.models;

import java.util.Collection;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank(message = "name can´t be empty value")
    private String nombre;

    @NotBlank(message = "cuil/cuit can´t be empty value")
    private String cuil_cuit;

    @Lob
    private byte[] imagen;

    @OneToMany
    private Collection<Chofer> choferes;

    @OneToMany
    private Collection<Micro> micros;

    @OneToMany
    private Collection<Pasaje> pasajes;

    /*
     * public void addChofer(Chofer ch){
     * if(!choferes.contains(ch)){
     * choferes.add(ch);
     * }
     * }
     * 
     * public void addMicro(Micro micro){
     * if(!micros.contains(micro)){
     * micros.add(micro);
     * }
     * }
     * 
     * public void deleteChofer(Chofer ch){
     * if(choferes.contains(ch)){
     * choferes.remove(ch);
     * }
     * }
     * 
     * public void addPasaje(Pasaje pasaje){
     * if(!pasajes.contains(pasaje)){
     * pasajes.add(pasaje);
     * }
     * }
     * 
     * public @NotBlank(message = "name can´t be empty value") String getNombre() {
     * return nombre;
     * }
     * 
     * public Collection<Micro> getMicros(){
     * return this.micros;
     * }
     */
}
