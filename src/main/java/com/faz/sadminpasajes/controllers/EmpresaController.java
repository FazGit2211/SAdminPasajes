package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.services.EmpresaServices;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("admin/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaServices empresaServices;

    @GetMapping
    public List<Empresa> getAll(){
        return empresaServices.getAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        return empresaServices.create(empresa);
    }

}
