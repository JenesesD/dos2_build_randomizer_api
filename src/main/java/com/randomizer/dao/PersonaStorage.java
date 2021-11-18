package com.randomizer.dao;

import com.randomizer.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaStorage {

    @Autowired
    PersonaRepository repository;

    public String getRace(int n) {
        return repository.getRace(n);
    }

    public List<String> getAttributes() { return repository.getAttributes(); }

    public List<String> getAbilities() { return repository.getAbilities(); }
}
