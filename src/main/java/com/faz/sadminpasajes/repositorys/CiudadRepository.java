package com.faz.sadminpasajes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
    Optional<Ciudad> findByIdAndNombre(int id, String nom);
}
