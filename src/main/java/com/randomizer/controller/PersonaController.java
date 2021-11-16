package com.randomizer.controller;

import com.randomizer.model.Persona;
import com.randomizer.service.Randomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonaController {
    Random random = new Random();
    Randomizer randomizer = new Randomizer();
    // private final AtomicLong counter = new AtomicLong();

    @GetMapping("/character")
    public List<Persona> getPersona(@RequestParam(value = "amount", defaultValue = "1")Integer amount) {
        List<Persona> characterList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            String race = randomizer.getRace(random);
            characterList.add(new Persona(race));
        }
        return characterList;
    }
}
