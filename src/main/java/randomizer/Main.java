package randomizer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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


    }
}
