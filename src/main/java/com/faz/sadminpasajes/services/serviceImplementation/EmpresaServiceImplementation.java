package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;
import com.faz.sadminpasajes.services.EmpresaServices;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImplementation implements EmpresaServices {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public ResponseEntity<Empresa> create(Empresa emp){
        Optional<Empresa> estaEmpresa = empresaRepository.findByNombre(emp.getNombre());
        return  (!estaEmpresa.isPresent()) ? ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(emp)) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    };

    @Override
    public List<Empresa>  getAll(){
        return empresaRepository.findAll();
    };
}
