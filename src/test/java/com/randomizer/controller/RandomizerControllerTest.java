package com.randomizer.controller;

import com.randomizer.service.RandomizerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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