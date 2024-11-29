package com.faz.sadminpasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Empresa;

public interface EmpresaServices {

    ResponseEntity<Empresa> create(Empresa emp);
    List<Empresa>  getAll();
    ResponseEntity<Empresa> findByNombre(String nombre);
<<<<<<< HEAD
    ResponseEntity<Empresa> addMicro(Long empresaId, Long microId);
    ResponseEntity<Empresa> addChofer(Long empresaId, Long choferId);
=======
    ResponseEntity<Empresa> addMicro(Micro micro, Long id);
    ResponseEntity<Empresa> addPasajeEnOferta(Long idEmpresa, Integer idPasaje);
>>>>>>> main
}
