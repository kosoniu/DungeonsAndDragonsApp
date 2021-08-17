package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RaceFeature {

    private final RaceFeatureId raceFeatureId;
    private final String name;
    private final String description;

    public RaceFeature(
            @JsonProperty("raceFeatureId") RaceFeatureId raceFeatureId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        this.raceFeatureId = raceFeatureId;
        this.name = name;
        this.description = description;
    }

    public RaceFeatureId getRaceFeatureId() {
        return raceFeatureId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
