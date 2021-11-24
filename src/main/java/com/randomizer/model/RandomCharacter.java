package com.randomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RandomCharacter {

    @Id
    private Integer id;
    private String race;
    private String gender;
    private boolean undead;

    @ElementCollection
    private List<String> attributes;

    @ElementCollection
    private List<String> abilities;
    private String civilAbility;

    @ElementCollection
    private List<String> skills;
    private String talent;
    private String instrument;
}
