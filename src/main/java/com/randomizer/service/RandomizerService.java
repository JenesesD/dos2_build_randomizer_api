package com.randomizer.service;

import com.randomizer.dao.PersonaStorage;
import com.randomizer.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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
            List<String> attributes = personaStorage.getAttributes();
            String selectedAttributes = joinListsIntoString(randomizeAttributes(random, attributes));
            personas.add(new Persona(i + 1, race, gender, selectedAttributes));
        }
        return personas;
    }

    // Method to help comprehension and readability
    // Generates a random number between 1 and n (inclusive)
    private int generateRandomNumber(Random random, int n) {
        return 1 + random.nextInt((n - 1) + 1);
    }

    // Method to help comprehension and readability
    // Joins list items together
    private String joinListsIntoString(List<String> list) { return String.join(", ", list); }

    // Method that will randomly select two non-matching attributes
    private List<String> randomizeAttributes(Random random, List<String> attributes) {
        List<String> randomAttributes = new LinkedList<>();

        // Necessary while loop in order to select non-matching values
        while (randomAttributes.size() != 2) {
            int randomNumber = random.nextInt(attributes.size());

            // Checks if the attribute selected is already in the randomAttributes List
            if (!randomAttributes.contains(attributes.get(randomNumber))) {
                randomAttributes.add(attributes.get(randomNumber));
            }
        }
        return randomAttributes;
    }
}
