package com.faz.sadminpasajes.services.serviceImplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.repositorys.ChoferRepository;
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

    @Autowired
    private ChoferRepository choferRepository;

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
        Optional<Empresa> existeEmpresa = empresaRepository.findByNombre(nombre);
        return (existeEmpresa.isPresent()) ? ResponseEntity.ok(existeEmpresa.get())
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity<Empresa> addMicro(Long empresaId, Long microId) {
        Optional<Empresa> existeEmpresa = empresaRepository.findById(empresaId);
        Optional<Micro> existeMicro = microRepository.findById(microId);
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
    }

    @Override
    public ResponseEntity<Empresa> addChofer(Long empresaId, Long choferId) {
        Optional<Empresa> existeEmpresa = empresaRepository.findById(empresaId);
        Optional<Chofer> existeChofer = choferRepository.findById(choferId);
        if (existeEmpresa.isPresent() && existeChofer.isPresent()) {
            try {
                /*
                Empresa empresa = existeEmpresa.get();
                Chofer chofer = existeChofer.get();
                empresa.addChofer(chofer);
                empresaRepository.save(empresa);
                */
                return ResponseEntity.ok(addEmpresa(existeEmpresa.get(), existeChofer));
            } catch (Exception e) {
                System.out.println("Error:" + e);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    };

    private Empresa addEmpresa(Empresa empresa, Object obj){
        if(obj instanceof Micro){
            Micro micro = (Micro) obj;
            empresa.addMicro(micro);                   
        }

        if(obj instanceof Chofer){
            Chofer chofer = (Chofer) obj;
            empresa.addChofer(chofer);            
        }

        return empresaRepository.save(empresa);
    }
}
