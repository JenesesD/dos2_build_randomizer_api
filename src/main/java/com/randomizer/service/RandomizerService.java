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
        // Create an instance of Random, so it can be passed to auxiliary methods
        Random random = new Random();

        // List that will contain the generated characters
        List<Persona> personas = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String race = personaStorage.getRace(generateRandomNumber(random, 4));
            String gender = generateRandomNumber(random, 100) > 50 ? "Male" : "Female";
            personas.add(new Persona(i + 1, race, gender));
        }
        return personas;
    }

    // Method to help comprehension and readability
    private int generateRandomNumber(Random random, int n) {
        return 1 + random.nextInt((n - 1) + 1);
    }
}
