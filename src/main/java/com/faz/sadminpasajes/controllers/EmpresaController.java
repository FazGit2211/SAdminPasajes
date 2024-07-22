package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody @Valid Empresa empresa){
        System.out.println(empresa);
        return empresaService.crearEmpresa(empresa);
    }
}
