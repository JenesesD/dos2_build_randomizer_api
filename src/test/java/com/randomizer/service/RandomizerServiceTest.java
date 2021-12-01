package com.randomizer.service;

import com.randomizer.dao.RandomCharacterStorage;
import com.randomizer.model.RandomCharacter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomizerServiceTest {

    @Autowired
    RandomizerService service;

    @MockBean
    RandomCharacterStorage storage;

    private Random random;

    @BeforeEach
    void init() {
        random = new Random();
        when(storage.getSkills("Warfare")).thenReturn(
                Arrays.asList("Battering Ram",  "Battle Stomp", "Bouncing Shield", "Crippling Blow"));

        when(storage.getAttributes()).thenReturn(Arrays.asList(
                "Strength", "Intelligence", "Wits", "Constitution", "Memory", "Finesse"
        ));

        when(storage.getAbilities()).thenReturn(Arrays.asList("Warfare", "Finesse"));
        when(storage.getTalent(2)).thenReturn("Ambidextrous");
    }

    @Test
    void createService() {
        assertNotNull(service);
    }


    // Figured out why IllegalArgumentException was thrown, had to mock other storage methods
    // that getCharacters uses in order for it to work
    @Test
    void getCharactersReturnValueInstanceOfRandomCharacter() {
        List<RandomCharacter> characters = service.getCharacters(2);
        assertThat(characters.get(0), instanceOf(RandomCharacter.class));
    }


    @Test
    void getCharactersReturnNotNull() {
        assertNotNull(service.getCharacters(2));
    }

    @Test
    void getCharacterReturnProperAmountOfCharacters() {
        List<RandomCharacter> characters = service.getCharacters(2);
        assertEquals(2, characters.size());
    }

    @Test
    void getCharacterReturnProperAmountOfCharactersWithInputLargerThanFour() {
        List<RandomCharacter> characters = service.getCharacters(6);
        assertEquals(4, characters.size());
    }

    @Test
    void getCharacterReturnProperAmountOfCharactersWithInputSmallerThanOne() {
        List<RandomCharacter> characters = service.getCharacters(0);
        assertEquals(1, characters.size());
    }

    @Test
    void getRandomTalentReturnNotNull() {
        String talent = storage.getTalent(2);
        assertNotNull(talent);
    }

    @Test
    void getRandomTalentReturnStringValue() {
        assertThat(storage.getTalent(2), instanceOf(String.class));
    }

    @Test
    void getGenderReturnStringValue() {
        assertThat(service.getGender(random), instanceOf(String.class));
    }

    @Test
    void getUndeadReturnBooleanValue() {
        assertThat(service.undeadStatus(random), instanceOf(Boolean.class));
    }

    @Test
    void paramCheckerWithInputBetweenOneAndFour() {
        int n = service.paramChecker(2);
        assertEquals(2, n);
    }

    @Test
    void paramCheckerWithInputLargerThanFour() {
        int n = service.paramChecker(8);
        assertEquals(4, n);
    }

    @Test
    void paramCheckerWithInputSmallerThanOne() {
        int n = service.paramChecker(0);
        assertEquals(1, n);
    }

    @Test
    void randomizeListItemsReturnNotNull() {
        List<String> items = storage.getAttributes();
        List<String> selectedItems = service.randomizeListItems(random, items);
        assertNotNull(selectedItems);
    }

    @Test
    void randomizeListItemsReturnListWithSizeOfTwo() {
        List<String> items = storage.getAttributes();
        Integer selectedItemsLength = service.randomizeListItems(random, items).size();
        assertEquals(2, selectedItemsLength);
    }

    @Test
    void randomizeSkillsReturnNotNull() {
        List<String> skills = Arrays.asList("Warfare", "Leadership");
        List<String> selectedSkills = service.randomizeSkills(random, skills);
        assertNotNull(selectedSkills);
    }

    @Test
    void randomizeSkillsReturnListWithSizeThree() {
        List<String> skills = Arrays.asList("Warfare", "Leadership");
        Integer selectedSkillsLength = service.randomizeSkills(random, skills).size();
        assertEquals(3, selectedSkillsLength);
    }

    @Test
    void createListCloneEqualsToOriginalList() {
        List<String> items =
                Arrays.asList("Strength", "Intelligence", "Wits", "Memory", "Constitution", "Finesse");
        assertEquals(service.createListClone(items), items);
    }
}