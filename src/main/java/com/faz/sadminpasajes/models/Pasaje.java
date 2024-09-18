package com.faz.sadminpasajes.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @NotBlank
    private String numero;

    @NotBlank
    private String formaPago;

    @NotBlank
    private float valor;

    @ManyToOne
    private Empresa empresaPasaje;

    @OneToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    public Pasaje(){}

    public void setEmpresa(Empresa empresa){
        this.empresaPasaje = empresa;
    }

}
