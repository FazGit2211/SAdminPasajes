package com.faz.sadminpasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Chofer;

public interface ChoferServices {
    
    ResponseEntity<Chofer> crearChofer(Chofer chofer);

    List<Chofer> getAll();
}
