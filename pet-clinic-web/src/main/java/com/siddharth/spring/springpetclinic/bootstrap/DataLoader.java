package com.siddharth.spring.springpetclinic.bootstrap;

import com.siddharth.spring.springpetclinic.model.Owner;
import com.siddharth.spring.springpetclinic.model.Vet;
import com.siddharth.spring.springpetclinic.services.OwnerService;
import com.siddharth.spring.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("siddharth");
        owner.setLastName("gupta");
        ownerService.save(owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Pranati");
        owner.setLastName("Jain");
        ownerService.save(owner);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Rakshit");
        vet.setLastName("Negi");
        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("Shrey");
        vet.setLastName("Shah");
        vetService.save(vet);

        System.out.println("Loaded Vets...");
    }
}
