package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.services.ChoferServices;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("admin/chofer")
public class ChoferController {

    @Autowired
    private ChoferServices choferServices;

    @PostMapping
    public ResponseEntity<Chofer> crearChoferes(@RequestBody @Valid Chofer chofer){
       return choferServices.crearChofer(chofer);
    }

    @GetMapping
    public List<Chofer> obtenerChoferes(){
        return choferServices.getAll();
    }

}
