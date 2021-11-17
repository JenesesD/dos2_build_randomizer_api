package com.randomizer.repository;

import com.randomizer.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT name FROM races WHERE id = :id", nativeQuery = true)
    String getRace(@Param("id") int id);
}
