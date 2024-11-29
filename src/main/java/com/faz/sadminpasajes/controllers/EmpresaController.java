package com.faz.sadminpasajes.controllers;

import com.faz.sadminpasajes.models.Empresa;
import com.faz.sadminpasajes.models.Micro;
import com.faz.sadminpasajes.services.EmpresaServices;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("admin/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaServices empresaServices;

    @GetMapping
    public List<Empresa> getAll(){
        return empresaServices.getAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        return empresaServices.create(empresa);
    }

    @GetMapping("/search/{nombre}")
    public ResponseEntity<Empresa> obtenerEmpresaByNombre(@PathVariable String nombre){
        return empresaServices.findByNombre(nombre);
    }

    @PutMapping("/addMicro/{id}")
    public ResponseEntity<Empresa> agregarMicro(@PathVariable Long id, @RequestBody Micro micro){
        return empresaServices.addMicro(micro, id);
    }

    @PutMapping("/addPasaje/{idEmpresa}/{idPasaje}")
    public ResponseEntity<Empresa> addPasaje(@PathVariable Long idEmpresa,@PathVariable Integer idPasaje){
        return empresaServices.addPasajeEnOferta(idEmpresa, idPasaje);
    }
}
