package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.repositorys.MicroRepository;
import com.faz.sadminpasajes.services.MicroServices;

public class MicroServiceImplementation implements MicroServices {

    @Autowired
    private MicroRepository microRepository;
    
    public ResponseEntity<Void> create(Micro micro){
        Optional<Micro> exist = microRepository.findByIdAndNumero(micro.getId(), micro.getNumero());
        if(!exist.isPresent()){
            microRepository.save(micro);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public Collection<Micro> getAll(){
        return microRepository.findAll();
    }
}
