package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Ciudad;
import com.faz.sadminpasajes.repositorys.CiudadRepository;
import com.faz.sadminpasajes.services.CiudadServices;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImplementation implements CiudadServices {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public ResponseEntity<Ciudad> create(Ciudad ciudad){
        Optional<Ciudad> exist = ciudadRepository.findByNombre(ciudad.getNombre());
        if(!exist.isPresent()){
            ciudadRepository.save(ciudad);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public List<Ciudad> getAll(){
        return ciudadRepository.findAll();
    }


    @Override
    public float calcularDistancias(String ciudadOrigen, String ciudadDestino){
        Optional<Ciudad> existCiudadOrigen = ciudadRepository.findByNombre(ciudadOrigen);
        Optional<Ciudad> existCiudadDestino = ciudadRepository.findByNombre(ciudadDestino);

        if (existCiudadOrigen.isPresent() && existCiudadDestino.isPresent()){
            return existCiudadOrigen.get().getDistancia() + existCiudadDestino.get().getDistancia();
        }
        return 0;
    }
}
