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

        // Checks the param provided for the method and changes the value accordingly
        int checkedParam = paramChecker(n);

        for (int i = 0; i < checkedParam; i++) {
            // Magic number represents the number of races
            String race = personaStorage.getRace(generateRandomNumber(random, 4));
            String gender = getGender(random);
            boolean isUndead = undeadStatus(random);
            String selectedAttributes = getRandomAttributes(random);

            // Left these two lines, since the randomAbilities variable is needed elsewhere
            List<String> randomAbilities = randomizeListItems(random, personaStorage.getAbilities());
            String selectedAbilities = joinListsIntoString(randomAbilities);

            // Magic number represents the number of civil abilities
            String civilAbility = personaStorage.getCivilAbility(generateRandomNumber(random, 7));

            // Randomizes and creates a string with the randomized skills
            String selectedSkills = joinListsIntoString(randomizeSkills(random, randomAbilities));

            // Magic number represents the number of talents
            String talent = personaStorage.getTalent(generateRandomNumber(random, 34));

            // Magic number represents the number of instruments
            String instrument = personaStorage.getInstrument(generateRandomNumber(random, 4));
            personas.add(new Persona(i + 1, race, gender, isUndead, selectedAttributes, selectedAbilities,
                    civilAbility, selectedSkills, talent, instrument));
        }
        return personas;
    }

    // Second endpoints service function, so if someone needs a random talent,
    // they don't have to generate a whole new character
    public String getRandomTalent() {
        Random random = new Random();
        int randomNumber = generateRandomNumber(random,34);
        return personaStorage.getTalent(randomNumber);
    }

    // Method to help comprehension and readability
    // Generates a random number between 1 and n (inclusive)
    private int generateRandomNumber(Random random, int n) {
        return 1 + random.nextInt((n - 1) + 1);
    }

    // Method to help comprehension and readability
    // Joins list items together
    private String joinListsIntoString(List<String> list) { return String.join(", ", list); }

    // Method that checks if the parameter given at the endpoint is suitable or not
    // if for some reason it's not usable, it switches the value accordingly
    private int paramChecker(int param) {
        int result = param;
        if (result < 0) { result = 1; }
        if (result > 4) { result = 4; }
        return result;
    }

    // Method to evaluate the gender of the character
    private String getGender(Random random) { return generateRandomNumber(random, 100) > 50 ? "Male" : "Female";  }

    // Evaluate the characters status as an undead
    private boolean undeadStatus(Random random) { return generateRandomNumber(random, 100) > 50; }

    private String getRandomAttributes(Random random) {
        List<String> randomAttributes = personaStorage.getAttributes();
        return joinListsIntoString(randomizeListItems(random, randomAttributes));
    }

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
            // this "if" is here so the api doesn't end up in an infinite loop
            if (abilities.size() == 0) {
                selectedSkills.add("None");
                break;
            }
            int randomNumber = random.nextInt(abilities.size());
            String temp = abilities.get(randomNumber);

            List<String> skills = personaStorage.getSkills(temp);

            // In order to not use a try/catch block, or get an exception
            // outer "if" to check the length of the skills list
            if (skills.size() != 0) {
                int randNum = random.nextInt(skills.size());

                // Checks if the selected value is already in the selectedSkills list
                if (!selectedSkills.contains(skills.get(randNum))) {
                    selectedSkills.add(skills.get(randNum));
                }
            } else {
                // If the code reaches the "else" clause, that means the selected ability
                // doesn't have corresponding skills, therefore redundant
                abilities.remove(randomNumber);
            }
        }
        return selectedSkills;
    }
}
