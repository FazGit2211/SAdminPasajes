package com.faz.sadminpasajes.services;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.faz.sadminpasajes.models.Micro;

public interface MicroServices {

    ResponseEntity<Void> create(Micro micro);

    Collection<Micro> getAll();
}
