package com.kos.character.proficiencies.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kos.character.origin.model.Origin;

import java.util.Set;

public class Proficiency {

    private final ProficiencyId proficiencyId;
    private final String name;
    private final ProficiencyType proficiencyType;

    @JsonCreator
    public Proficiency(
            @JsonProperty("proficiencyId") ProficiencyId proficiencyId,
            @JsonProperty("name") String name,
            @JsonProperty("proficiencyType") ProficiencyType proficiencyType
    ) {
        this.proficiencyId = proficiencyId;
        this.name = name;
        this.proficiencyType = proficiencyType;
    }

    public ProficiencyId getProficiencyId() {
        return proficiencyId;
    }

    public String getName() {
        return name;
    }

    public ProficiencyType getProficiencyType() {
        return proficiencyType;
    }

}
