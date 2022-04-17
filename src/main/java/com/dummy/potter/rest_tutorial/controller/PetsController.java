package com.dummy.potter.rest_tutorial.controller;

import com.dummy.potter.rest_tutorial.event.CustomEvent;
import com.dummy.potter.rest_tutorial.event.CustomEventPublisher;
import com.dummy.potter.rest_tutorial.model.Pets;
import com.dummy.potter.rest_tutorial.service.PetService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet")
public class PetsController {

    private final static Logger logger = LoggerFactory.getLogger(PetsController.class);

    @Autowired
    private PetService petService;
    @Autowired
    private CustomEventPublisher publisher;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
//        logger.trace("cont. A TRACE Message");
        logger.debug("cont. A DEBUG Message");
//        logger.info("cont. An INFO Message");
//        logger.warn("cont. A WARN Message");
//        logger.error("cont. An ERROR Message");
        publisher.publish(new CustomEvent(this, "test invoked"));
        return petService.testService();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets(){
        return petService.getAllPets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id, @RequestParam Map<String, String> requestParam){
        logger.info(requestParam.toString());
        return petService.getPetById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modifyPetById(@PathVariable("id") ObjectId id, @RequestBody Pets pet){
        return petService.modifyPetById(id, pet);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(@RequestBody Pets pet){
        return petService.createPet(pet);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePet(@PathVariable ObjectId id){
        return petService.deletePet(id);
    }
}
