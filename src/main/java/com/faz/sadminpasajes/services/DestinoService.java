package com.faz.sadminpasajes.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.faz.sadminpasajes.models.Destino;
import com.faz.sadminpasajes.repositorys.DestinoRepository;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;


    public ResponseEntity<Void> create(Destino destino){
        Optional<Destino> exits = destinoRepository.findById(destino.getId());
        if (!exits.isPresent()) {
            destinoRepository.save(destino);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public Collection<Destino> getAll(){
        return destinoRepository.findAll();
    }
}
