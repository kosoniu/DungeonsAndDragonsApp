package com.kos.character.race.db;

import javax.persistence.*;

@Entity
@Table(name = "race_feature")
public class RaceFeatureEntity {

    @Id
    @Column(name = "race_feature_id")
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }
}
