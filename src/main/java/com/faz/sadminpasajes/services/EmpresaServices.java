package com.faz.sadminpasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Empresa;

public interface EmpresaServices {

    ResponseEntity<Empresa> create(Empresa emp);
    List<Empresa>  getAll();
}
