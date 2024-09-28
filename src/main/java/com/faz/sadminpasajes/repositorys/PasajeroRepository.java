package com.faz.sadminpasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Pasajero;

public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {

}
