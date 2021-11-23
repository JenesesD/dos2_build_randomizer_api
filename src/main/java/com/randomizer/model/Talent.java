package com.randomizer.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Talent {

    @Id
    private Integer id;
    private String name;
}
