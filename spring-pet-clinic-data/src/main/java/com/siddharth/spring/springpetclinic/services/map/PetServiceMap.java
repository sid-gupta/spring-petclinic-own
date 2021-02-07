package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.Pet;

public class PetServiceMap extends AbstractMapService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return this.save(object.getId(), object);
    }
}
