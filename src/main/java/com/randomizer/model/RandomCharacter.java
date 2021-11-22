package com.randomizer.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class RandomCharacter {

    @Id
    private final Integer id;
    private final String race;
    private final String gender;
    private final boolean undead;

    @ElementCollection
    private final List<String> attributes;

    @ElementCollection
    private final List<String> abilities;
    private final String civilAbility;

    @ElementCollection
    private final List<String> skills;
    private final String talent;
    private final String instrument;

    public RandomCharacter(Integer id, String race, String gender, boolean undead, List<String> attributes, List<String> abilities,
                           String civilAbility, List<String> skills, String talent, String instrument) {
        this.id = id;
        this.race = race;
        this.gender = gender;
        this.undead = undead;
        this.attributes = attributes;
        this.abilities = abilities;
        this.civilAbility = civilAbility;
        this.skills = skills;
        this.talent = talent;
        this.instrument = instrument;
    }

    public Integer getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public boolean isUndead() {
        return undead;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public String getCivilAbility() {
        return civilAbility;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getTalent() {
        return talent;
    }

    public String getInstrument() {
        return instrument;
    }
}
