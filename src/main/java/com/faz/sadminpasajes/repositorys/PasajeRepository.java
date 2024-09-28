package com.faz.sadminpasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Pasaje;

public interface PasajeRepository extends JpaRepository<Pasaje,Long> {

}
