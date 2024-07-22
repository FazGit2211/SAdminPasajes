package com.faz.sadminpasajes.repositorys;

import com.faz.sadminpasajes.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
}
