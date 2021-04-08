package com.kos.character.hero.model;

import com.kos.character.race.model.RaceId;

public class Hero {

    private HeroId heroId;
    private String name;
    private Integer level;
    private RaceId raceId;

    public Hero(HeroId heroId, String name, Integer level, RaceId raceId) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.raceId = raceId;
    }

    public void setHeroId(HeroId heroId) {
        this.heroId = heroId;
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

    public RaceId getRaceId() {
        return raceId;
    }
}
