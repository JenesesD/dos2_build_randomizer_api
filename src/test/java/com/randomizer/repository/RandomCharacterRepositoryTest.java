package com.randomizer.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RandomCharacterRepositoryTest {

    @Autowired
    private RandomCharacterRepository repository;

    @Test
    void getRaceByIdReturnNotNull() {
        assertNotNull(repository.getRace(3));
    }

    @Test
    void getRaceByIdReturnStringValue() { assertThat(repository.getRace(3), instanceOf(String.class)); }

    @Test
    void getRaceByIdReturnAppropriateValue() {
        List<String> races = Arrays.asList("Dwarf", "Elf", "Lizard", "Human");
        String race = repository.getRace(3);
        assertTrue(races.contains(race));
    }

    @Test
    void getRaceByIdReturnNullWithInvalidId() {
        assertNull(repository.getRace(8));
    }

    @Test
    void getAttributesReturnNotNull() {
        assertNotNull(repository.getAttributes());
    }

    @Test
    void getAttributesReturnListValue() {
        assertThat(repository.getAttributes(), instanceOf(List.class));
    }

    @Test
    void getAttributesReturnListWithAppropriateLength() {
        assertEquals(6, repository.getAttributes().size());
    }

    @Test
    void getAbilities() {
    }

    @Test
    void getCivilAbility() {
    }

    @Test
    void getSkills() {
    }

    @Test
    void getTalent() {
    }

    @Test
    void getInstrument() {
    }
}