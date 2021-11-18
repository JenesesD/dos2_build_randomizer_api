package com.randomizer.dao;

import com.randomizer.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaStorage {

    @Autowired
    PersonaRepository repository;

    public String getRace(int id) {
        return repository.getRace(id);
    }

    public List<String> getAttributes() { return repository.getAttributes(); }

    public List<String> getAbilities() { return repository.getAbilities(); }

    public String getCivilAbility(int id) { return repository.getCivilAbility(id); }

    public String getTalent(int id) { return repository.getTalent(id); }

    public String getInstrument(int id) { return repository.getInstrument(id); }
}
