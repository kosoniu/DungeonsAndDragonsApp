package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RaceFeatureId {

    private final int value;

    public RaceFeatureId(int value) {
        this.value = value;
    }

    public static RaceFeatureId of(int value) { return new RaceFeatureId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceFeatureId raceFeatureId = (RaceFeatureId) o;
        return value == raceFeatureId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
