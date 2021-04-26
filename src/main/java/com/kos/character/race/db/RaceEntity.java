package com.kos.character.race.db;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "race")
public class RaceEntity {

    @Id
    @Column(name = "race_id")
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "race")
    private Set<RaceFeatureEntity> raceFeatureEntities;

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

    public Set<RaceFeatureEntity> getRaceFeatureEntities() {
        return raceFeatureEntities;
    }

    public void setRaceFeatureEntities(Set<RaceFeatureEntity> raceFeatureEntities) {
        this.raceFeatureEntities = raceFeatureEntities;
    }
}
