package com.faz.sadminpasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;

public interface EmpresaServices {

    ResponseEntity<Empresa> create(Empresa emp);
    List<Empresa>  getAll();
    ResponseEntity<Empresa> findByNombre(String nombre);
    ResponseEntity<Empresa> addMicro(Micro micro, Long id);
}
