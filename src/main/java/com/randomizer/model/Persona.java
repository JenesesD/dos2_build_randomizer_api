package com.randomizer.model;

import lombok.Data;


import java.util.List;

@Data
public class Persona {
    private long id;
    private Gender gender;
    private Race race;
    private boolean isUndead;
    private List<String> attributes;
    private List<String> abilities;
    private List<String> civilAbilities;
    private String startingTalent;


}
