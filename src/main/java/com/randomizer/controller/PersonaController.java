package com.randomizer.controller;

import com.randomizer.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonaController {
        // For the time being these Lists will be hardcoded here
        // TODO: Create a database around it

        // Need 3 Attributes
        List<String> ATTRIBUTES = Arrays.asList("Strength", "Finesse", "Intelligence",
                "Constitution", "Memory", "Wits");

        // Need 2 Abilities
        List<String> ABILITIES = Arrays.asList("Dual Wielding", "Ranged", "Single-Handed", "Two-Handed", "Leadership", "Perserverance",
                "Retribution", "Aerotheurge", "Geomancer", "Huntsman", "Hydrosophist", "Necromancer", "Polymorph",
                "Pyrokinetic", "Scoundrel", "Summoning", "Warfare");

        //Need 2 Civil Abilities
        List<String> CIVIL_ABILITIES = Arrays.asList("Telekinesis", "Loremaster", "Sneaking", "Thievery", "Bartering",
                "Persuasion", "Lucky Charm");

        List<String> TALENTS = Arrays.asList("All Skilled Up", "Ambidextrous", "Arrow Recovery", "Bigger and better",
                "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Escapist", "Executioner",
                "Elemental Ranger", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerrilla",
                "Hothead", "Ice King", "Leech", "Living Armour", "Lonewolf", "Mnemonic", "Morning Person",
                "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", "Slingshot",
                "Stench", "The Pawn", "Torturer", "Unstable", "Walk It Off", "What a Rush");


    @GetMapping("/character")
    public Integer getPersona(@RequestParam(value = "amount") String amount) {
        return null;
    }
}
