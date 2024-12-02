package com.faz.sadminpasajes.services.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faz.sadminpasajes.models.PasajeOferta;
import com.faz.sadminpasajes.repositorys.PasajeEnOfertaRepository;
import com.faz.sadminpasajes.services.PasajeDeOfertaService;
@Service
public class PasajeOfertaImplement implements PasajeDeOfertaService{
    @Autowired
    private PasajeEnOfertaRepository pasajeEnOfertaRepository;
    @Override
    public ResponseEntity<PasajeOferta> create(PasajeOferta pasaje) {
        try {
            pasajeEnOfertaRepository.save(pasaje);
            return ResponseEntity.ok(pasaje);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

}
