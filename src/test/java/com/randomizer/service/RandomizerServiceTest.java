package com.randomizer.service;

import com.randomizer.dao.RandomCharacterStorage;
import org.junit.jupiter.api.BeforeAll;
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

    @BeforeAll
    void init() {
        random = new Random();
        when(storage.getAbilities()).thenReturn(new ArrayList<String>(
                Arrays.asList("Strength", "Intelligence", "Wits", "Memory", "Constitution", "Finesse")) );
    }

    @Test
    void createService() {
        assertNotNull(service);
    }

    @Test
    void getCharacters() {
    }

    @Test
    void getRandomTalentReturnNotNull() {
        when(storage.getTalent(2)).thenReturn("Ambidextrous");
        String talent = storage.getTalent(2);
        assertNotNull(talent);
    }

    @Test
    void getGenderReturnStringValue() {
        assertThat(service.getGender(random), instanceOf(String.class));
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
    void randomizeListItemsMethodReturnNotNull() {
        List<String> items = storage.getAbilities();
        List<String> selectedItems = service.randomizeListItems(random, items);
        assertNotNull(selectedItems);
    }

    @Test
    void randomizeListItemsMethodReturnListWithSizeOfTwo() {
        List<String> items = storage.getAbilities();
        Integer selectedItemsLength = service.randomizeListItems(random, items).size();
        assertEquals(2, selectedItemsLength);
    }

    @Test
    void randomizeSkills() {
    }

    @Test
    void createListClone() {
    }
}