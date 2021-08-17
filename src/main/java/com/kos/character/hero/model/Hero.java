package com.kos.character.hero.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kos.character.clazz.model.Class;
import com.kos.character.origin.model.Origin;
import com.kos.character.race.model.Race;

public class Hero {

    private final HeroId heroId;
    private final String name;
    private final Integer level;
    private final Race race;
    private final Origin origin;
    private final Class clazz;

    @JsonCreator
    public Hero(
            @JsonProperty("heroId") HeroId heroId,
            @JsonProperty("name") String name,
            @JsonProperty("level") Integer level,
            @JsonProperty("race") Race race,
            @JsonProperty("origin") Origin origin,
            @JsonProperty("clazz") Class clazz) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.race = race;
        this.origin = origin;
        this.clazz = clazz;
    }

    public HeroId getHeroId() {
        return heroId;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Race getRace() {
        return race;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Class getClazz() {
        return clazz;
    }
}
