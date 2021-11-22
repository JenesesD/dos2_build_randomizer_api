package com.randomizer.controller;

import com.randomizer.model.RandomCharacter;
import com.randomizer.model.Talent;
import com.randomizer.service.RandomizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RandomizerController {

    @Autowired
    RandomizerService randomizerService;

    @GetMapping("/character")
    public List<RandomCharacter> getPersona(@RequestParam(value = "amount", defaultValue = "1")Integer amount) {
        return randomizerService.getCharacters(amount);
    }

    @GetMapping("/talent")
    public Talent getTalent() { return randomizerService.getRandomTalent(); }
}
