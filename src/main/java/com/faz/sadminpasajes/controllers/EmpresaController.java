package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.services.EmpresaServices;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "admin/empresa",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpresaController {
    @Autowired
    private EmpresaServices empresaServices;

    @GetMapping()
    public List<Empresa> getAllEmpresas(){
        return empresaServices.getAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(@RequestBody @Valid Empresa empresa){
        return empresaServices.create(empresa);
    }

    @GetMapping("/search/{nombre}")
    public ResponseEntity<Empresa> getEmpresaByName(@PathVariable String nombre){
        return empresaServices.findByNombre(nombre);
    }

    @PutMapping("/addMicro/{empresaId}/{microId}")
    public ResponseEntity<Empresa> addMicro(@PathVariable Long empresaId, @PathVariable Long microId){
        return empresaServices.addMicro(empresaId, microId);
    }

    @PutMapping("/addPasaje/{idEmpresa}/{idPasaje}")
    public ResponseEntity<Empresa> addPasaje(@PathVariable Long idEmpresa,@PathVariable Integer idPasaje){
        return empresaServices.addPasajeEnOferta(idEmpresa, idPasaje);
    }
}
