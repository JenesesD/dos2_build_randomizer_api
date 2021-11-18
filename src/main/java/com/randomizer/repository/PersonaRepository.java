package com.randomizer.repository;

import com.randomizer.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    // Query that selects a single race based on the parameter id
    @Query(value = "SELECT name FROM races WHERE id = :id", nativeQuery = true)
    String getRace(@Param("id") int id);

    // Not sure which would be more efficient, one "large" query or two "small" queries
    // Query that selects all attributes
    @Query(value = "SELECT name FROM attributes", nativeQuery = true)
    List<String> getAttributes();

    // Query that selects all abilities
    @Query(value = "SELECT name FROM abilities", nativeQuery = true)
    List<String> getAbilities();
}
