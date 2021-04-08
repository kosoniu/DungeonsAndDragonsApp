package com.kos.character.hero.db;

import com.kos.character.race.db.RaceEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "hero")
public class HeroEntity {

    @Id
    @GeneratedValue
    @NotNull
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int level;

    @ManyToOne
    @NotNull
    private RaceEntity race;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }
}
