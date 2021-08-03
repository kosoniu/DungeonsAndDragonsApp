package com.kos.character.race.model;

import java.util.Set;

public class Race {

    private RaceId raceId;
    private String name;
    private String description;
    private Set<RaceFeature> raceFeatures;

    public Race(RaceId raceId, String name, String description, Set<RaceFeature> raceFeatures) {
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

    public void setRaceId(RaceId raceId) {
        this.raceId = raceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RaceFeature> getRaceFeatures() {
        return raceFeatures;
    }

    public void setRaceFeatures(Set<RaceFeature> raceFeatures) {
        this.raceFeatures = raceFeatures;
    }
}
