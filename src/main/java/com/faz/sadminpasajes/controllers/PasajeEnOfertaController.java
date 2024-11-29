package com.faz.sadminpasajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faz.sadminpasajes.models.PasajeOferta;
import com.faz.sadminpasajes.services.PasajeDeOfertaService;

@RestController
@RequestMapping("/pasajeOferta")
public class PasajeEnOfertaController {
    @Autowired
    private PasajeDeOfertaService pasajeDeOfertaService;

    @PostMapping
    public ResponseEntity<PasajeOferta> createNew(@RequestBody PasajeOferta pasaje){
        return pasajeDeOfertaService.create(pasaje);
    }
}
