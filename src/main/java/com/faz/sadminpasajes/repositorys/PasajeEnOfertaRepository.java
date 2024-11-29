package com.faz.sadminpasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.PasajeOferta;

public interface PasajeEnOfertaRepository extends JpaRepository<PasajeOferta, Integer>{
}
