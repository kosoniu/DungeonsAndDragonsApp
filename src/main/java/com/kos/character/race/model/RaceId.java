package com.kos.character.race.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RaceId {

    private final int value;

    public RaceId(int value) {
        this.value = value;
    }

    public static RaceId of(int value) { return new RaceId(value); }

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
