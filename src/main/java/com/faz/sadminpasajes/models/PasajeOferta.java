package com.faz.sadminpasajes.models;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class PasajeOferta extends Pasaje{

    private Date fechaVigencia;
    
    private Date fechaCaducidad;

    public PasajeOferta(int id, String numero, String formaPago, float valor, Destino destino, Date fechaVigencia,
            Date fechaCaducidad) {
        super(id, numero, formaPago, valor, destino);
        this.fechaVigencia = fechaVigencia;
        this.fechaCaducidad = fechaCaducidad;
    }

    public PasajeOferta(){}

    
}
