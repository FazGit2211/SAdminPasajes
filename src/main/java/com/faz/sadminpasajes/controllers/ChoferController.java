package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.services.ChoferServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChoferController {
    @Autowired
    private ChoferServices choferServices;
    @PostMapping
    public ResponseEntity<Chofer> crearChofer(@RequestBody @Valid Chofer chofer){
        return  choferServices.crearChofer(chofer);
    }
}
