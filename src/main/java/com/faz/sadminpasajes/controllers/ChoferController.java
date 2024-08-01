package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.services.ChoferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("admin/chofer")
public class ChoferController {

    @Autowired
    private ChoferService chServ;


    @GetMapping
    public List<Chofer> obtenerChoferes(){
        return chServ.getAll();
    }

    @PostMapping
    public ResponseEntity<Chofer> addChofer(@RequestBody @Valid Chofer chofer){
        return chServ.crearChofer(chofer);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Chofer> obtPorId(@PathVariable int id){
        return chServ.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actChofer(@PathVariable int id,@RequestBody Chofer ch){
        return chServ.actualizar(id,ch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBy(@PathVariable int id){
        return chServ.delete(id);
    }
}
