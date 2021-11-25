package com.randomizer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RandomizerServiceTest {

    @Autowired
    RandomizerService service;

    @Test
    void createService() {
        assertNotNull(service);
    }

    @Test
    void getCharacters() {
    }

    @Test
    void getRandomTalent() {
    }

    @Test
    void generateRandomNumber() {
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
    void getGender() {
    }

    @Test
    void undeadStatus() {
    }

    @Test
    void randomizeListItems() {
    }

    @Test
    void randomizeSkills() {
    }

    @Test
    void createListClone() {
    }
}