package com.randomizer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    private final Integer id;
    private final String race;
    // private final String gender;
//    private final String attributes;
//    private final String abilities;
//    private final String civilAbility;
//    private final String skills;
//    private final String talent;
//    private final String instrument;

    // String attributes, String abilities, String civilAbility, String skills, String talent, String instrument
    public Persona(Integer id, String race) {
        this.id = id;
        this.race = race;
//        this.attributes = attributes;
//        this.abilities = abilities;
//        this.civilAbility = civilAbility;
//        this.skills = skills;
//        this.talent = talent;
//        this.instrument = instrument;
    }

    public Integer getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

//    public String getAttributes() {
//        return attributes;
//    }
//
//    public String getAbilities() {
//        return abilities;
//    }
//
//    public String getCivilAbility() {
//        return civilAbility;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public String getTalent() {
//        return talent;
//    }
//
//    public String getInstrument() {
//        return instrument;
//    }
}
