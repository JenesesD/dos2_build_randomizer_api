package com.randomizer.controller;

import com.randomizer.model.RandomCharacter;
import com.randomizer.service.RandomizerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RandomizerController.class)
class RandomizerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RandomizerController controller;

    @MockBean
    private RandomizerService service;

    @Test
    void createMockMvc() {
        assertNotNull(mvc);
    }

    @Test
    void getRandomCharacterStatusCodeWithoutParamTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getRandomCharactersStatusCodeWithParamTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character?amount=4"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getRandomCharactersStatusCodeWithIncorrectParamTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character?amount=a"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getRandomCharacterContentTypeWithoutParamTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character"))
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void getRandomCharactersContentTypeWithParamTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character?amount=4"))
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldReturnRandomCharacterWithValues() throws Exception {
        when(service.getCharacters(1)).thenReturn(List.of(
                new RandomCharacter(0, "Lizard", "Male", true, Arrays.asList("Strength", "Wits"),
                        Arrays.asList("Warfare", "Scoundrel"), "Bartering",
                        Arrays.asList("Chloroform", "Bouncing Shield", "Backlash"),
                        "Pet Pal", "Cello" )));

        this.mvc.perform(MockMvcRequestBuilders.get("/character"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].race").value("Lizard"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].undead").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].attributes")
                        .value(Matchers.containsInAnyOrder("Strength", "Wits")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].abilities")
                        .value(Matchers.containsInAnyOrder("Warfare", "Scoundrel")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].civilAbility").value("Bartering"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].skills")
                        .value(Matchers.containsInAnyOrder("Chloroform", "Bouncing Shield", "Backlash")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].talent").value("Pet Pal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].instrument").value("Cello"));
    }

    @Test
    void getRandomCharacterListLengthWithInputBetweenOneAndFour() throws Exception {
        when(service.getCharacters(2)).thenReturn(List.of(new RandomCharacter(), new RandomCharacter()));

        this.mvc.perform((MockMvcRequestBuilders.get("/character?amount=2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void getRandomCharacterListLengthWithInputLargerThanFour() throws Exception {
        when(service.getCharacters(6)).thenReturn(List.of(new RandomCharacter(), new RandomCharacter(),
                new RandomCharacter(), new RandomCharacter()));

        this.mvc.perform((MockMvcRequestBuilders.get("/character?amount=6")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(4));
    }

    @Test
    void getRandomCharactersListLengthWithInputLessThanOne() throws Exception {
        when(service.getCharacters(0)).thenReturn(List.of(new RandomCharacter()));

        this.mvc.perform((MockMvcRequestBuilders.get("/character?amount=0")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

    @Test
    void getRandomTalentTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/talent"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getRandomTalentContentTypeTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/talent"))
                .andExpect(content().contentType("application/json"));
    }
}