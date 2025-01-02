package com.faz.sadminpasajes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.faz.sadminpasajes.models.Ciudad;
import com.faz.sadminpasajes.services.CiudadServices;

@RestController
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.OPTIONS})
@RequestMapping("admin/city")
public class CiudadController {

    @Autowired
    private CiudadServices ciudadServices;

    @PostMapping
    public ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad){
        return ciudadServices.create(ciudad);
    }

    @GetMapping
    public Collection<Ciudad> getAll(){
        return ciudadServices.getAll();
    }

    @GetMapping("/calcular")
    public float obtenerDistancias(@RequestParam String ciudadOrigen, @RequestParam String ciudadDestino){
        return ciudadServices.calcularDistancias(ciudadOrigen,ciudadDestino);
    }
}
