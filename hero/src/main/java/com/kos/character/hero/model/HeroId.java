package com.kos.character.hero.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class HeroId implements Serializable {

    private static final long serialVersionUID = -4906633323154089542L;

    private final int value;

    public HeroId(int value) { this.value = value; }

    public static HeroId of(int value) { return new HeroId(value); }

    public int asInt() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroId heroId = (HeroId) o;
        return value == heroId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
