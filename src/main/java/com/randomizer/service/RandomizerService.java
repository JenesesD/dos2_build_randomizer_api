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
            // Magic number represents the number of races
            String race = personaStorage.getRace(generateRandomNumber(random, 4));

            // Ternary to evaluate the gender of the character
            String gender = generateRandomNumber(random, 100) > 50 ? "Male" : "Female";

            // Evaluate the characters status as an undead
            boolean isUndead = generateRandomNumber(random, 100) > 50;

            // Probably will write a separate method for these method calls
            List<String> attributes = personaStorage.getAttributes();
            String selectedAttributes = joinListsIntoString(randomizeListItems(random, attributes));

            // Same with these method calls
            List<String> randomAbilities =randomizeListItems(random, personaStorage.getAbilities());
            String selectedAbilites = joinListsIntoString(randomAbilities);

            // Magic number represents the number of civil abilities
            String civilAbility = personaStorage.getCivilAbility(generateRandomNumber(random, 7));

            String skills = joinListsIntoString(randomizeSkills(random, randomAbilities));

            // Magic number represents the number of talents
            String talent = personaStorage.getTalent(generateRandomNumber(random, 34));

            // 4 = number of instruments
            String instrument = personaStorage.getInstrument(generateRandomNumber(random, 4));


            personas.add(new Persona(i + 1, race, gender, isUndead, selectedAttributes, selectedAbilites,
                    civilAbility, skills, talent, instrument));
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

    // Method that will randomly select two non-matching values
    private List<String> randomizeListItems(Random random, List<String> list) {
        List<String> randomValues = new LinkedList<>();

        // Necessary while loop in order to select non-matching values
        while (randomValues.size() != 2) {
            int randomNumber = random.nextInt(list.size());

            // Checks if the selected value is already in the randomValues List
            if (!randomValues.contains(list.get(randomNumber))) {
                randomValues.add(list.get(randomNumber));
            }
        }
        return randomValues;
    }

    // Method that will randomly select three skills according to the abilities list
    private List<String> randomizeSkills(Random random, List<String> abilities) {
        List<String> selectedSkills = new LinkedList<>();

        // Necessary while loop in order to select non-matching values
        while (selectedSkills.size() != 3) {

            // It is possible to get abilities that don't have corresponding skills,
            // this evaluation is here so the api doesn't end up in an infinite loop
            if (abilities.size() == 0) { break; }
            int randomNumber = random.nextInt(abilities.size());
            String temp = abilities.get(randomNumber);

            List<String> skills = personaStorage.getSkills(temp);

            // In order to not use a try/catch block, or get an exception
            // outer if to check the length of the skills list
            if (skills.size() != 0) {
                int randNum = random.nextInt(skills.size());

                // Checks if the selected value is already in the selectedSkills list
                if (!selectedSkills.contains(skills.get(randNum))) {
                    selectedSkills.add(skills.get(randNum));
                }
            } else {
                // If the code reaches the else clause, that means the selected ability
                // doesn't have corresponding skills, therefore redundant
                abilities.remove(randomNumber);
            }
        }
        return selectedSkills;
    }
}
