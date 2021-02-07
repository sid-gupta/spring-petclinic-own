package com.siddharth.spring.springpetclinic.services;

import com.siddharth.spring.springpetclinic.model.Owner;

public interface OnwerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
