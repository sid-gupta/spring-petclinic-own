package com.siddharth.spring.springpetclinic.services;

import com.siddharth.spring.springpetclinic.model.Owner;

import java.util.Set;

public interface OnwerService {
    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
