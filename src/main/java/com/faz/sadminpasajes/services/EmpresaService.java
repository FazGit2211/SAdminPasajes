package com.faz.sadminpasajes.services;


import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;
import java.util.HashSet;
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

    public ResponseEntity<Void> addMicroEmpresa(String nombre,Micro micro){
        Optional<Empresa> empresaExist = empresaRepository.findByNombre(nombre);
        if (empresaExist.isPresent()) {
            try {
                Empresa empresa = empresaExist.get();
                empresa.addMicro(micro);
                empresaRepository.save(empresa);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error" + e.getMessage());
            }
        }
        return ResponseEntity.badRequest().build();
    }


    public HashSet<Micro> getByIdMicro(String nombre){
        Optional<Empresa> empresaExist = empresaRepository.findByNombre(nombre);
        if(empresaExist.isPresent()){
            HashSet<Micro> micros = new HashSet<>(empresaExist.get().getMicros());
            return micros;
        }
        return null;
    }
}
