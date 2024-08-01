package com.faz.sadminpasajes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faz.sadminpasajes.models.Ciudad;
import com.faz.sadminpasajes.services.CiudadService;

@RestController
@RequestMapping("admin/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Ciudad ciudad){
        return ciudadService.create(ciudad);
    }

    @GetMapping
    public Collection<Ciudad> getAll(){
        return ciudadService.getAll();
    }

    @GetMapping("/{id}/{nombre}")
    public ResponseEntity<Ciudad> getByIdAndNombre(@PathVariable int id, @PathVariable String nombre){
        return ciudadService.getByIdAndNombre(id,nombre);
    }
}
