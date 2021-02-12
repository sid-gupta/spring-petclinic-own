package com.siddharth.spring.springpetclinic.bootstrap;

import com.siddharth.spring.springpetclinic.model.*;
import com.siddharth.spring.springpetclinic.services.OwnerService;
import com.siddharth.spring.springpetclinic.services.PetTypeService;
import com.siddharth.spring.springpetclinic.services.SpecialityService;
import com.siddharth.spring.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        specialityService.save(dentistry);

        Pet petOne = new Pet();
        petOne.setPetType(dog);
        petOne.setName("rambo");
        petOne.setBirthDay(LocalDate.now());

        Pet petTwo = new Pet();
        petTwo.setPetType(cat);
        petTwo.setName("mike");
        petTwo.setBirthDay(LocalDate.now());

        Owner owner = new Owner();
        owner.setFirstName("siddharth");
        owner.setLastName("gupta");
        owner.setAddress("24 mangal nagar");
        owner.setCity("sre");
        owner.setTelephone("923483");
        owner.getPets().add(petOne);
        ownerService.save(owner);

        owner = new Owner();
        owner.setFirstName("Pranati");
        owner.setLastName("Jain");
        owner.setAddress("24 mangal nagar");
        owner.setCity("sre");
        owner.setTelephone("923483");
        owner.getPets().add(petTwo);
        ownerService.save(owner);

        Vet vet = new Vet();
        vet.setFirstName("Rakshit");
        vet.setLastName("Negi");
        vet.getSpecialities().add(radiology);
        vet.getSpecialities().add(surgery);
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Shrey");
        vet.setLastName("Shah");
        vet.getSpecialities().add(surgery);
        vet.getSpecialities().add(dentistry);
        vetService.save(vet);
    }
}
