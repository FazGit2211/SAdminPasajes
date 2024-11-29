package com.faz.sadminpasajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faz.sadminpasajes.models.PasajeDeCompra;
import com.faz.sadminpasajes.services.PasajeDeCompraService;

@RestController
@RequestMapping("/pasajeCompra")
public class PasajeDeCompraController {
    @Autowired
    private PasajeDeCompraService pasajeDeCompraService;

    @PostMapping
    public ResponseEntity<PasajeDeCompra> createNew(@RequestBody PasajeDeCompra pasaje){
        return pasajeDeCompraService.create(pasaje);
    }
}
