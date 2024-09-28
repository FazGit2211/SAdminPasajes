package com.faz.sadminpasajes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
    Optional<Ciudad> findByNombre(String nom);
    Optional<Ciudad> findByIdAndNombre(Long id,String nom);
}
