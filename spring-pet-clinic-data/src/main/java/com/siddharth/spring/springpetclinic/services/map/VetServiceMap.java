package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.Vet;
import com.siddharth.spring.springpetclinic.services.SpecialityService;
import com.siddharth.spring.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        object.getSpecialities().forEach(speciality -> {
            if (speciality.getId() == null) {
                specialityService.save(speciality);
            }
        });
        return super.save(object);
    }
}
