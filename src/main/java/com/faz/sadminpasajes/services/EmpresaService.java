package com.faz.sadminpasajes.services;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.repositorys.ChoferRepository;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ChoferRepository choferRepository;

    public ResponseEntity<Empresa> create(Empresa emp){
        Optional<Empresa> estaEmpresa = empresaRepository.findByNombre(emp.getNombre());
        return  (!estaEmpresa.isPresent()) ? ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(emp)) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public List<Empresa>  getAll(){
        return empresaRepository.findAll();
    }

    public ResponseEntity<Void> deleteById(int id){
        Optional<Empresa> estaEmpresa = empresaRepository.findById(id);
        if(estaEmpresa.isPresent()){
            Empresa emp = estaEmpresa.get();
            empresaRepository.delete(emp);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Void> updateById(int id, Empresa empresaUpdate){
        Optional<Empresa> estaEmpresa = empresaRepository.findById(id);
        if(estaEmpresa.isPresent()){
            estaEmpresa.get().updateValues(empresaUpdate);;
            empresaRepository.save(estaEmpresa.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
