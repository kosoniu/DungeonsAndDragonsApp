package com.kos.character.hero.model;

import com.kos.character.race.model.Race;

public class Hero {

    private HeroId heroId;
    private String name;
    private Integer level;
    private Race race;

    public Hero(HeroId heroId, String name, Integer level, Race race) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.race = race;
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

    public Race getRace() {
        return race;
    }
}
