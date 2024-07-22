package com.faz.sadminpasajes.services;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public ResponseEntity<Empresa> crearEmpresa(Empresa emp){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(emp));
    }
}
