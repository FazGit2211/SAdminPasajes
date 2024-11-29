package com.faz.sadminpasajes.services;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.PasajeDeCompra;

public interface PasajeDeCompraService {
    ResponseEntity<PasajeDeCompra> create(PasajeDeCompra pasajeOferta);
}
