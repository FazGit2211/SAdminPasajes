package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.repositorys.ChoferRepository;
import com.faz.sadminpasajes.services.ChoferServices;


public class ChoferImplementation implements ChoferServices {

    @Autowired
    private ChoferRepository chRepo;

    public ResponseEntity<Chofer> crearChofer(Chofer chofer){
        Optional<Chofer> estaChofer = chRepo.findByDni(chofer.getDni());
        if(!estaChofer.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(chRepo.save(chofer));
        }else{
            System.out.println("Chofer ya existe");
        }
        
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    };

    public List<Chofer> getAll(){
        return chRepo.findAll();
    };
}
