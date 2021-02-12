package com.siddharth.spring.springpetclinic.bootstrap;

import com.siddharth.spring.springpetclinic.model.Owner;
import com.siddharth.spring.springpetclinic.model.Pet;
import com.siddharth.spring.springpetclinic.model.PetType;
import com.siddharth.spring.springpetclinic.model.Vet;
import com.siddharth.spring.springpetclinic.services.OwnerService;
import com.siddharth.spring.springpetclinic.services.PetTypeService;
import com.siddharth.spring.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

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
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Shrey");
        vet.setLastName("Shah");
        vetService.save(vet);
    }
}
