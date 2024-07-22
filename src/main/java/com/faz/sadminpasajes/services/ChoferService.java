package com.faz.sadminpasajes.services;


import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.repositorys.ChoferRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Service
public class ChoferService {
    @Autowired
    private ChoferRepository chRepo;

    public ResponseEntity<Chofer> crearChofer(Chofer chofer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chRepo.save(chofer));
    }


    public List<Chofer> getAll() {
        return chRepo.findAll();
    }

    public ResponseEntity<Chofer> obtenerPorId(int id){
        Optional<Chofer> ch = chRepo.findById(id);
        return ResponseEntity.ok(ch.get()   );
    }
}
