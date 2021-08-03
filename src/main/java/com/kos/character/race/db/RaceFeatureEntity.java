package com.kos.character.race.db;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "race_feature")
public class RaceFeatureEntity implements Serializable {

    private static final long serialVersionUID = 3928771155121404725L;

    @Id
    @Column(name = "race_feature_id")
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

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

}
