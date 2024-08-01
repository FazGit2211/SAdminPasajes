package com.faz.sadminpasajes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faz.sadminpasajes.models.Destino;
import com.faz.sadminpasajes.services.DestinoService;

@RestController
@RequestMapping("admin/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Destino destino){
        return destinoService.create(destino);
    }

    @GetMapping
    public Collection<Destino> getAll(){
        return destinoService.getAll();
    }
}
