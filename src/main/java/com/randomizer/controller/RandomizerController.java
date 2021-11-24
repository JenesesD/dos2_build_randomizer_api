package com.randomizer.controller;

import com.randomizer.model.RandomCharacter;
import com.randomizer.model.Talent;
import com.randomizer.service.RandomizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RandomizerController {

    @Autowired
    RandomizerService randomizerService;

    @GetMapping("/character")
    public List<RandomCharacter> getRandomCharacter(@RequestParam(value = "amount", defaultValue = "1")Integer amount) {
        return randomizerService.getCharacters(amount);
    }

    @GetMapping("/talent")
    public ResponseEntity<Talent> getTalent() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Talent>(randomizerService.getRandomTalent(), httpHeaders, HttpStatus.OK);
    }
}
