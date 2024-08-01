package com.faz.sadminpasajes.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faz.sadminpasajes.models.Ciudad;
import com.faz.sadminpasajes.repositorys.CiudadRepository;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public ResponseEntity<Void> create(Ciudad ciudad){
        Optional<Ciudad> exist = ciudadRepository.findByIdAndNombre(ciudad.getId(), ciudad.getNombre());
        if (!exist.isPresent()) {
            ciudadRepository.save(ciudad);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public Collection<Ciudad> getAll(){
        return ciudadRepository.findAll();
    }

    public ResponseEntity<Ciudad> getByIdAndNombre(int id, String nom){
        Optional<Ciudad> exist = ciudadRepository.findByIdAndNombre(id, nom);
        return !exist.isPresent() ? ResponseEntity.ok().body(exist.get()) : ResponseEntity.badRequest().build();
    }
}
