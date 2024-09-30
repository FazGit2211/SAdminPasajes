package com.faz.sadminpasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Ciudad;

public interface CiudadServices {

    ResponseEntity<Ciudad> create(Ciudad ciudad);

    List<Ciudad> getAll();

    float calcularDistancias(String ciudadOrigen, String ciudadDestino);
}
