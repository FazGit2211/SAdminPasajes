package com.faz.sadminpasajes.services.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faz.sadminpasajes.models.PasajeDeCompra;
import com.faz.sadminpasajes.repositorys.PasajeDeCompraRepository;
import com.faz.sadminpasajes.services.PasajeDeCompraService;
@Service
public class PasajeDeCompraImplement implements PasajeDeCompraService {
    @Autowired
    private PasajeDeCompraRepository pasajeDeCompraRepository;

    @Override
    public ResponseEntity<PasajeDeCompra> create(PasajeDeCompra pasaje) {
        try {
            pasajeDeCompraRepository.save(pasaje);
            return ResponseEntity.ok(pasaje);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

}
