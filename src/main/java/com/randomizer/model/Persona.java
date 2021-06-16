package com.randomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
