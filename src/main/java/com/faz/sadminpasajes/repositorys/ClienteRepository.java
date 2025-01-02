package com.faz.sadminpasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faz.sadminpasajes.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
