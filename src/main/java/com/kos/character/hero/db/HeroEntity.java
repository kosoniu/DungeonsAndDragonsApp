package com.kos.character.hero.db;

import com.kos.character.clazz.db.ClassEntity;
import com.kos.character.origin.db.OriginEntity;
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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int level;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity clazz;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private OriginEntity origin;

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

    public ClassEntity getClazz() {
        return clazz;
    }

    public void setClazz(ClassEntity clazz) {
        this.clazz = clazz;
    }

    public OriginEntity getOrigin() {
        return origin;
    }

    public void setOrigin(OriginEntity origin) {
        this.origin = origin;
    }
}
