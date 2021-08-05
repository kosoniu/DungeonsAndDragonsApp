package com.kos.character.clazz.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClassId implements Serializable {

    private static final long serialVersionUID = -4906633323154089542L;

    private final int value;

    @JsonCreator
    private ClassId(@JsonProperty("value") int value) { this.value = value; }

    public static ClassId of(int value) { return new ClassId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassId heroId = (ClassId) o;
        return value == heroId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
