package com.faz.sadminpasajes.services;


import com.faz.sadminpasajes.models.Chofer;
import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.repositorys.ChoferRepository;
import com.faz.sadminpasajes.repositorys.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ChoferService {
    @Autowired
    private ChoferRepository chRepo;

    @Autowired
    private EmpresaRepository empresaRepository;


    public ResponseEntity<Chofer> crearChofer(Chofer chofer) {
        Optional<Chofer> estaChofer = chRepo.findByDni(chofer.getDni());
        if(!estaChofer.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(chRepo.save(chofer));
        }else{
            System.out.println("Chofer ya existe");
        }
        
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }


    public List<Chofer> getAll() {
        return chRepo.findAll();
    }

    public ResponseEntity<Chofer> obtenerPorId(int id){
        Optional<Chofer> ch = chRepo.findById(id);
        return ResponseEntity.ok(ch.get()   );
    }

    public ResponseEntity<Void> actualizar(int id,Chofer choferUpdate){
        Optional<Chofer> estaChofer = chRepo.findById(id);
        if(estaChofer.isPresent()){
            estaChofer.get().setApellido(choferUpdate.getApellido());
            estaChofer.get().setDni(choferUpdate.getDni());
            estaChofer.get().setNombre(choferUpdate.getNombre());
            estaChofer.get().setLicencia(choferUpdate.getLicencia());
            chRepo.save(estaChofer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Void> delete(int id){
        Optional<Chofer> estaChofer = chRepo.findById(id);
        Optional<Empresa> empresa = empresaRepository.findById(estaChofer.get().getEmpresa().getId());
        if(estaChofer.isPresent() && empresa.isPresent()){
            empresa.get().deleteChofer(estaChofer.get());
            chRepo.delete(estaChofer.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
