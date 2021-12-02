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
    void getAbilitiesReturnNotNull() {
        assertNotNull(repository.getAbilities());
    }

    @Test
    void getAbilitiesReturnListValue() {
        assertThat(repository.getAbilities(), instanceOf(List.class));
    }

    @Test
    void getAbilitiesListWithAppropriateLength() { assertEquals(17, repository.getAbilities().size()); }

    @Test
    void getCivilAbilityReturnNotNull() { assertNotNull(repository.getCivilAbility(2));  }

    @Test
    void getCivilAbilityReturnStringValue() { assertThat(repository.getCivilAbility(2), instanceOf(String.class)); }

    @Test
    void getCivilAbilityReturnAppropriateValue() {
        List<String> civilAbilities = Arrays.asList(
                "Bartering", "Lucky Charm", "Persuasion", "Loremaster", "Telekinesis", "Sneaking", "Thievery");
        String civilAbility = repository.getCivilAbility(2);
        assertTrue(civilAbilities.contains(civilAbility));
    }

    @Test
    void getCivilAbilityReturnNullWithInvalidId() {assertNull(repository.getCivilAbility(9)); }

    @Test
    void getSkillsReturnNotNull() {
        assertNotNull(repository.getSkills("Warfare"));
    }

    @Test
    void getSkillsReturnListValue() { assertThat(repository.getSkills("Warfare"), instanceOf(List.class)); }

    @Test
    void getSkillsReturnListWithAppropriateLength() {
        assertEquals(4, repository.getSkills("Warfare").size());
    }

    @Test
    void getTalentReturnNotNull() { assertNotNull(repository.getTalent(8)); }

    @Test
    void getTalentReturnStringValue() { assertThat(repository.getTalent(8), instanceOf(String.class)); }

    @Test
    void getTalentReturnNullWithInvalidId() { assertNull(repository.getCivilAbility(88)); }

    @Test
    void getInstrumentReturnNotNull() { assertNotNull(repository.getInstrument(2)); }

    @Test
    void getInstrumentReturnStringValue() { assertThat(repository.getInstrument(2), instanceOf(String.class)); }

    @Test
    void getInstrumentReturnAppropriateValue() {
        List<String> instruments = Arrays.asList("Cello", "Tambura", "Bansuri", "Oud");
        String instrument = repository.getInstrument(2);
        assertTrue(instruments.contains(instrument));
    }

    @Test
    void getInstrumentReturnNullWithInvalidId() { assertNull(repository.getInstrument(9)); }
}