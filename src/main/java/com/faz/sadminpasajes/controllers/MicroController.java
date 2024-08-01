package com.faz.sadminpasajes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.services.MicroService;

@RestController
@RequestMapping("admin/micro")
public class MicroController {

    @Autowired
    private MicroService microService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Micro micro){
        return microService.create(micro);
    }

    @GetMapping
    public Collection<Micro> getAll(){
        return microService.getAll();
    }

    @GetMapping("/")
    public ResponseEntity<Micro> getById(@RequestParam int id,@RequestParam String num){
        return microService.getByIdAndNumero(id, num);
    }
}
