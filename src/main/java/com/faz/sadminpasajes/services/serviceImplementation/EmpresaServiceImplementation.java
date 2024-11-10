package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;
import com.faz.sadminpasajes.repositorys.MicroRepository;
import com.faz.sadminpasajes.services.EmpresaServices;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImplementation implements EmpresaServices {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private MicroRepository microRepository;

    @Override
    public ResponseEntity<Empresa> create(Empresa emp) {
        Optional<Empresa> estaEmpresa = empresaRepository.findByNombre(emp.getNombre());
        return (!estaEmpresa.isPresent()) ? ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(emp))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    };

    @Override
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @Override
    public ResponseEntity<Empresa> findByNombre(String nombre) {
        // TODO Auto-generated method stub
        Optional<Empresa> existeEmpresa = empresaRepository.findByNombre(nombre);
        return (existeEmpresa.isPresent()) ? ResponseEntity.ok(existeEmpresa.get())
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity<Empresa> addMicro(Micro micro, Long id) {
        Optional<Empresa> existeEmpresa = empresaRepository.findById(id);
        Optional<Micro> existeMicro = microRepository.findByIdAndNumero(micro.getId(), micro.getNumero());
        if (existeEmpresa.isPresent() && existeMicro.isPresent()) {
            try {
                Empresa empresa = existeEmpresa.get();
                Micro microActual = existeMicro.get();
                empresa.addMicro(microActual);
                empresaRepository.save(empresa);
                return ResponseEntity.ok(empresa);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    };

}
