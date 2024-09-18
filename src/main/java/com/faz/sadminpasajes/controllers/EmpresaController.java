package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.services.EmpresaService;
import jakarta.validation.Valid;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("admin/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAll(){
        return empresaService.getAll();
    }

    @GetMapping("/{nombre}")
    public HashSet<Micro> getById(@PathVariable String nombre){
        return empresaService.getByIdMicro(nombre);
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        return empresaService.create(empresa);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneId(@PathVariable int id){
        return empresaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Empresa empresa){
        return empresaService.updateById(id,empresa);
    }

    @PostMapping("/{nombre}")
    public ResponseEntity<Void> addMicro(@PathVariable String nombre, @RequestBody Micro micro){
        return empresaService.addMicroEmpresa(nombre, micro);
    }

}
