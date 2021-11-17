package com.randomizer.controller;

import com.randomizer.model.Persona;
import com.randomizer.service.RandomizerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    RandomizerService randomizerService = new RandomizerService();

    @GetMapping("/character")
    public List<Persona> getPersona(@RequestParam(value = "amount", defaultValue = "1")Integer amount) {
        return randomizerService.getCharacters(amount);
    }
}
