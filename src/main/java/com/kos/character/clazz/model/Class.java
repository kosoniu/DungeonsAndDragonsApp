package com.kos.character.clazz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kos.character.proficiencies.model.Proficiency;

import java.util.List;

public class Class {

    private final ClassId classId;
    private final String name;
    private final String description;
    private final Integer hitDice;
    private final Integer healthPoints;
    private final Integer hitDiceOnHigherLevels;
    private final List<Proficiency> proficiencies;

    public Class(
            @JsonProperty("classId") ClassId classId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("hitDice") Integer hitDice,
            @JsonProperty("healthPoints") Integer healthPoints,
            @JsonProperty("hitDiceOnHigherLevels") Integer hitDiceOnHigherLevels,
            @JsonProperty("proficiencies") List<Proficiency> proficiencies) {
        this.classId = classId;
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.healthPoints = healthPoints;
        this.hitDiceOnHigherLevels = hitDiceOnHigherLevels;
        this.proficiencies = proficiencies;
    }

    public String getName() {
        return name;
    }

    public ClassId getClassId() {
        return classId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHitDice() {
        return hitDice;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Integer getHitDiceOnHigherLevels() {
        return hitDiceOnHigherLevels;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }
}
