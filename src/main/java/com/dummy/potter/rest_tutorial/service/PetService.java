package com.dummy.potter.rest_tutorial.service;

import com.dummy.potter.rest_tutorial.model.Pets;
import org.bson.types.ObjectId;

import java.util.List;

public interface PetService {
    List<Pets> getAllPets();
    Pets getPetById(ObjectId id);
    String modifyPetById(ObjectId id, Pets pet);
    Pets createPet(Pets pet);
    String deletePet(ObjectId id);

    String testService();
}
