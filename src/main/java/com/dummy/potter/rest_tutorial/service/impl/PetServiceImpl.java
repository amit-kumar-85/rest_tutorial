package com.dummy.potter.rest_tutorial.service.impl;

import com.dummy.potter.rest_tutorial.aop.annotation.LogExecutionTime;
import com.dummy.potter.rest_tutorial.exception.model.CustomException;
import com.dummy.potter.rest_tutorial.model.Pets;
import com.dummy.potter.rest_tutorial.repository.PetsRepository;
import com.dummy.potter.rest_tutorial.service.PetService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final static Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

    @Autowired
    private PetsRepository petsRepository;

    @Override
    public String testService() {

        for(int i=0;i<1000;++i) {
            logger.info(i+"th INFO Message");
        }
        return "ok";
    }

    @Override
    @LogExecutionTime
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

    @Override
    @LogExecutionTime
    public Pets getPetById(ObjectId id) {
        Pets pet = petsRepository.findBy_id(id);
        if(pet == null){
            throw new CustomException("Pet with given Id does not exists");
        }
        return pet;
    }

    @Override
    @LogExecutionTime
    public String modifyPetById(ObjectId id, Pets pet) {
        pet.set_id(id);
        petsRepository.save(pet);
        return "success";
    }

    @Override
    @LogExecutionTime
    public Pets createPet(Pets pet) {
        pet.set_id(ObjectId.get());
        petsRepository.save(pet);
        return pet;
    }

    @Override
    @LogExecutionTime
    public String deletePet(ObjectId id) {
        petsRepository.delete(petsRepository.findBy_id(id));
        return "success";
    }
}
