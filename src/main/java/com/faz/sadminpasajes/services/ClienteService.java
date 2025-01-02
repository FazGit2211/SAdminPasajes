package com.faz.sadminpasajes.services;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Cliente;

public interface ClienteService {
    ResponseEntity<Cliente> create(Cliente cliente);
}
