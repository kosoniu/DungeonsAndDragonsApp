package com.kos.character.race.model;

public class Race {

    private RaceId raceId;
    private String name;

    public Race(RaceId raceId, String name) {
        this.raceId = raceId;
        this.name = name;
    }

    public RaceId getRaceId() {
        return raceId;
    }

    public String getName() {
        return name;
    }
}
