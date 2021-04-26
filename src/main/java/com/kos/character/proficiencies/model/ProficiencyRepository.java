package com.kos.character.proficiencies.model;

import java.util.List;
import java.util.Optional;

public interface ProficiencyRepository {

    Optional<Proficiency> findBy(ProficiencyId proficiencyId);

    List<Proficiency> findAll();

    Proficiency add(Proficiency proficiency);

    Proficiency update(Proficiency proficiency);

    void delete(Integer id);

}
