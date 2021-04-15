package com.kos.character.origin.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OriginId {

    private final int value;

    private OriginId(int value) { this.value = value; }

    @JsonCreator
    public static OriginId of(@JsonProperty("value") int value) { return new OriginId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginId heroId = (OriginId) o;
        return value == heroId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
