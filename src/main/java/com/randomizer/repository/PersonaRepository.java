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

    // Query that selects a single civil ability based on the parameter
    @Query(value = "SELECT name FROM civil_abilities WHERE id = :id", nativeQuery = true)
    String getCivilAbility(@Param("id") int id);

    // Query that selects a single talent based on the parameter
    @Query(value = "SELECT name FROM talents WHERE id = :id", nativeQuery = true)
    String getTalent(@Param("id") int id);

    @Query(value = "SELECT name FROM instruments WHERE id = :id", nativeQuery = true)
    String getInstrument(@Param("id") int id);
}
