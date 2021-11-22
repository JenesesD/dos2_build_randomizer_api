package com.randomizer.repository;

import com.randomizer.model.RandomCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RandomCharacterRepository extends JpaRepository<RandomCharacter, Long> {

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

    // Query that selects all skills where the type is equal with the stored type
    @Query(value = "SELECT name FROM skills WHERE skill_type = :type", nativeQuery = true)
    List<String> getSkills(@Param("type") String type);

    // Query that selects a single talent based on the parameter
    @Query(value = "SELECT name FROM talents WHERE id = :id", nativeQuery = true)
    String getTalent(@Param("id") int id);

    // Query that selects a single instrument based on the parameter
    @Query(value = "SELECT name FROM instruments WHERE id = :id", nativeQuery = true)
    String getInstrument(@Param("id") int id);
}
