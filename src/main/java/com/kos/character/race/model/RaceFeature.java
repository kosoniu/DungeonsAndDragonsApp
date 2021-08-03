package com.kos.character.race.model;

public class RaceFeature {

    private RaceFeatureId raceFeatureId;
    private String name;
    private String description;

    public RaceFeature(RaceFeatureId raceFeatureId, String name, String description) {
        this.raceFeatureId = raceFeatureId;
        this.name = name;
        this.description = description;
    }

    public RaceFeatureId getRaceFeatureId() {
        return raceFeatureId;
    }

    public void setRaceFeatureId(RaceFeatureId raceFeatureId) {
        this.raceFeatureId = raceFeatureId;
    }

    public String getName() {
        return name;
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

}
