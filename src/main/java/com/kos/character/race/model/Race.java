package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class Race {

    private final RaceId raceId;
    private final String name;
    private final String description;
    private final Set<RaceFeature> raceFeatures;

    @JsonCreator
    public Race(
            @JsonProperty("raceId") RaceId raceId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("raceFeatures") Set<RaceFeature> raceFeatures) {
        this.raceId = raceId;
        this.name = name;
        this.description = description;
        this.raceFeatures = raceFeatures;
    }

    public RaceId getRaceId() {
        return raceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<RaceFeature> getRaceFeatures() {
        return raceFeatures;
    }

}
