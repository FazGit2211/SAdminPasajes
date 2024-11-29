package com.faz.sadminpasajes.services;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.PasajeOferta;

public interface PasajeDeOfertaService {
    ResponseEntity<PasajeOferta> create(PasajeOferta pasajeOferta);
}
