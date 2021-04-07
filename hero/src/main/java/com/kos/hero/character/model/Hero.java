package com.kos.hero.character.model;

public class Hero {

    private HeroId heroId;
    private String name;
    private Integer level;

    public Hero(HeroId heroId, String name, Integer level) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
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
}
