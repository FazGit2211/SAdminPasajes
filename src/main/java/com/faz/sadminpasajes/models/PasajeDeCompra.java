package com.faz.sadminpasajes.models;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class PasajeDeCompra extends Pasaje{
    private Date fechaCompra;

    public PasajeDeCompra(int id, String numero, String formaPago, float valor, Destino destino, Date fecha) {
        super(id, numero, formaPago, valor, destino);
        this.fechaCompra = fecha;
    }

    public PasajeDeCompra() {
    }

    
}
