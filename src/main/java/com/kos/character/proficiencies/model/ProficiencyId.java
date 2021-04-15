package com.kos.character.proficiencies.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProficiencyId implements Serializable {

    private static final long serialVersionUID = 528199140873772180L;

    private final int value;

    private ProficiencyId(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ProficiencyId of(@JsonProperty("value") int value) { return new ProficiencyId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProficiencyId that = (ProficiencyId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
