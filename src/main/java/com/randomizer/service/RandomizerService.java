package com.randomizer.service;

import com.randomizer.dao.PersonaStorage;
import com.randomizer.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomizerService {

    @Autowired
    PersonaStorage personaStorage;

    public List<Persona> getCharacters(int n) {
        Random random = new Random();
        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int randomNumber = generateRandomNumber(random, 4);
            String race = personaStorage.getRace(randomNumber);
            personas.add(new Persona(i + 1, race));
        }
        return personas;
    }

    private int generateRandomNumber(Random random, int n) {
        return 1 + random.nextInt((n - 1) + 1);
    }
}
