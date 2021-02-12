package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.Owner;
import com.siddharth.spring.springpetclinic.services.OwnerService;
import com.siddharth.spring.springpetclinic.services.PetService;
import com.siddharth.spring.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            throw new RuntimeException("object cannot be null");
        }
        object.getPets().forEach(pet -> {
            if (pet.getPetType() == null)
                throw new RuntimeException("Pet Type cannot be null for a pet");

            // if new PetType then save that
            if (pet.getPetType().getId() == null)
                petTypeService.save(pet.getPetType());

            pet.setOwner(object);
            petService.save(pet);
        });
        return super.save(object);
    }
}
