package com.randomizer.service;

import com.randomizer.dao.RandomCharacterStorage;
import com.randomizer.model.RandomCharacter;
import com.randomizer.model.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class RandomizerService {

    @Autowired
    RandomCharacterStorage randomCharacterStorage;

    public List<RandomCharacter> getCharacters(int n) {

        // Create an instance of Random, so it can be passed to auxiliary methods
        Random random = new Random();

        // List that will contain the generated characters
        List<RandomCharacter> randomCharacters = new ArrayList<>();

        // Checks the param provided for the method and changes the value accordingly
        int checkedParam = paramChecker(n);

        for (int i = 0; i < checkedParam; i++) {
            // Magic number represents the number of races
            String race = randomCharacterStorage.getRace(generateRandomNumber(random, 4));
            String gender = getGender(random);
            boolean isUndead = undeadStatus(random);

            // Removed the Stringification method call, the requester can handle the data how they please
            List<String> selectedAttributes = randomizeListItems(random, randomCharacterStorage.getAttributes());
            List<String> selectedAbilities = randomizeListItems(random, randomCharacterStorage.getAbilities());

            // Magic number represents the number of civil abilities
            String civilAbility = randomCharacterStorage.getCivilAbility(generateRandomNumber(random, 7));

            // Randomizes skills depending on the selected abilities
            List<String> selectedSkills = randomizeSkills(random, selectedAbilities);

            // Magic number represents the number of talents
            String talent = randomCharacterStorage.getTalent(generateRandomNumber(random, 34));

            // Magic number represents the number of instruments
            String instrument = randomCharacterStorage.getInstrument(generateRandomNumber(random, 4));
            randomCharacters.add(new RandomCharacter(i, race, gender, isUndead, selectedAttributes, selectedAbilities,
                    civilAbility, selectedSkills, talent, instrument));
        }
        return randomCharacters;
    }

    // Second endpoint service function, so if someone needs a random talent,
    // they don't have to generate a whole new character
    public Talent getRandomTalent() {
        Random random = new Random();
        int randomNumber = generateRandomNumber(random,34);
        return new Talent(0, randomCharacterStorage.getTalent(randomNumber));
    }

    // Method to help comprehension and readability
    // Generates a random number between 1 and n (inclusive)
    protected int generateRandomNumber(Random random, int n) {
        return 1 + random.nextInt((n - 1) + 1);
    }

    // Method that checks if the parameter given at the endpoint is suitable or not
    // if for some reason it's not usable, it switches the value accordingly
    protected int paramChecker(int param) {
        int result = param;
        if (result < 1) { result = 1; }
        if (result > 4) { result = 4; }
        return result;
    }

    // Method to evaluate the gender of the character
    protected String getGender(Random random) { return generateRandomNumber(random, 100) > 50 ? "Male" : "Female";  }

    // Evaluate the characters status as an undead
    protected boolean undeadStatus(Random random) { return generateRandomNumber(random, 100) > 50; }

    // Method that will randomly select two non-matching values
    protected List<String> randomizeListItems(Random random, List<String> list) {
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
    protected List<String> randomizeSkills(Random random, List<String> abilities) {
        List<String> selectedSkills = new LinkedList<>();

        // Create a deep copy of abilities
        List<String> copy = createListClone(abilities);

        // Necessary while loop in order to select non-matching values
        while (selectedSkills.size() != 3) {

            // It is possible to get abilities that don't have corresponding skills,
            // this "if" is here so the api doesn't end up in an infinite loop
            if (copy.size() == 0) { selectedSkills.add("None"); break; }

            int randomNumber = random.nextInt(copy.size());
            String temp = copy.get(randomNumber);

            List<String> skills = randomCharacterStorage.getSkills(temp);

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
                copy.remove(randomNumber);
            }
        }
        return selectedSkills;
    }

    protected List<String> createListClone(List<String> abilities) {
        return new ArrayList<>(abilities);
    }
}
