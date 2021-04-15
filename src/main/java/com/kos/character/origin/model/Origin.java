package com.kos.character.origin.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kos.character.proficiencies.model.Proficiency;

import java.util.List;
import java.util.Set;

public class Origin {

    private final OriginId originId;
    private final String name;
    private final String description;
    private final List<Proficiency> proficiencies;

    @JsonCreator
    public Origin(
            @JsonProperty("originId") OriginId originId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("proficiencies") List<Proficiency> proficiencies) {
        this.originId = originId;
        this.name = name;
        this.description = description;
        this.proficiencies = proficiencies;
    }

    public OriginId getOriginId() {
        return originId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }
}
