package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RaceId implements Serializable {

    private static final long serialVersionUID = -3197585948538404057L;

    private final int value;

    private RaceId(int value) {
        this.value = value;
    }

    @JsonCreator
    public static RaceId of(@JsonProperty("value") int value) { return new RaceId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceId raceId = (RaceId) o;
        return value == raceId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
