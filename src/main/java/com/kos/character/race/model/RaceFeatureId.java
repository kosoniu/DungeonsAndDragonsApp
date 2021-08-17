package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RaceFeatureId implements Serializable {

    private static final long serialVersionUID = -8974374891276180223L;

    private final int value;

    private RaceFeatureId(int value) {
        this.value = value;
    }

    @JsonCreator
    public static RaceFeatureId of(@JsonProperty("value") int value) { return new RaceFeatureId(value); }

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
