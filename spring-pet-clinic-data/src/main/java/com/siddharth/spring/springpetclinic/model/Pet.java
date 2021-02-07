package com.siddharth.spring.springpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity<Long> {
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDay() {
        return birthDate;
    }

    public void setBirthDay(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
