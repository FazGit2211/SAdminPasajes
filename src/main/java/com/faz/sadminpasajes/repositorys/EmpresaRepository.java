package com.faz.sadminpasajes.repositorys;

import com.faz.sadminpasajes.models.Empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
    Optional<Empresa> findByNombre(String nom);
}
