package com.randomizer.dao;

import com.randomizer.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaStorage {

    @Autowired
    PersonaRepository repository;

    public String getRace(int n) {
        return repository.getRace(n);
    }
}
