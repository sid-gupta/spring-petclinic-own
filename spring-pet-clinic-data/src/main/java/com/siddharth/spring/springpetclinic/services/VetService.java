package com.siddharth.spring.springpetclinic.services;

import com.siddharth.spring.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
