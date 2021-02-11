package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.PetType;
import com.siddharth.spring.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
}
