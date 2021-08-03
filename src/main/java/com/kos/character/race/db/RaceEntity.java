package com.kos.character.race.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "race")
public class RaceEntity implements Serializable {

    private static final long serialVersionUID = -7732372564213352972L;

    @Id
    @Column(name = "race_id")
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="race_id", nullable=false)
    private Set<RaceFeatureEntity> raceFeatures;

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

    public Set<RaceFeatureEntity> getRaceFeatures() {
        return raceFeatures;
    }

    public void setRaceFeatures(Set<RaceFeatureEntity> raceFeatureEntities) {
        this.raceFeatures = raceFeatureEntities;
    }
}
