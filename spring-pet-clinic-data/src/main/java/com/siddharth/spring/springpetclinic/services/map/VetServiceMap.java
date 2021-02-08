package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.Vet;
import com.siddharth.spring.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return this.save(object.getId(), object);
    }
}
