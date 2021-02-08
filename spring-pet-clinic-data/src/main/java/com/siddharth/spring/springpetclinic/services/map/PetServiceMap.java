package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.Pet;
import com.siddharth.spring.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(Pet object) {
        return this.save(object.getId(), object);
    }
}
