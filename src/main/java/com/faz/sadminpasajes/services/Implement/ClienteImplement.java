package com.faz.sadminpasajes.services.Implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.faz.sadminpasajes.models.Cliente;
import com.faz.sadminpasajes.repositorys.ClienteRepository;
import com.faz.sadminpasajes.services.ClienteService;

@Service
public class ClienteImplement implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<Cliente> create(Cliente cliente) {
        try {
            Optional<Cliente> exist = clienteRepository.findById(cliente.getId());
            if (!exist.isPresent()) {
                Cliente clienteExist = exist.get();
                clienteRepository.save(clienteExist);
                return ResponseEntity.ok(clienteExist);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.badRequest().build();
    }

}
