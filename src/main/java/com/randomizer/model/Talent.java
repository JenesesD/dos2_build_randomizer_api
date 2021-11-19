package com.randomizer.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Talent {

    @Id
    private final Integer id;
    private final String name;

    public Talent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
