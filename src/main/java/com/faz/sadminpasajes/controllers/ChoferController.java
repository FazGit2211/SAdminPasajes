package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.services.ChoferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Chofer> actChofer(@PathVariable int id,@RequestBody Chofer ch){
        ResponseEntity<Chofer> choferExistente = chServ.obtenerPorId(id);
        System.out.println(choferExistente.getBody());
        if(!choferExistente.getBody().equals(null)){
            System.out.println("Existe el chofer");
            return chServ.crearChofer(ch);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
