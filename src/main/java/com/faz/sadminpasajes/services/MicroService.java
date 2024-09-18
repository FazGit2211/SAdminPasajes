package com.faz.sadminpasajes.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.repositorys.MicroRepository;

@Service
public class MicroService {

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

    public ResponseEntity<Micro> getByIdAndNumero(int id,String num){
        Optional<Micro> exist = microRepository.findByIdAndNumero(id, num);
        if(exist.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(exist.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
