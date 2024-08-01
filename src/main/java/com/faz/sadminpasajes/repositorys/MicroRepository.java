package com.faz.sadminpasajes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Micro;

public interface MicroRepository extends JpaRepository<Micro,Integer> {
    Optional<Micro> findByIdAndNumero(int id,String numero);
}
