package com.faz.sadminpasajes.repositorys;


import com.faz.sadminpasajes.models.Chofer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoferRepository extends JpaRepository<Chofer,Long> {
    
    Optional<Chofer> findByDni(int dni);
}
