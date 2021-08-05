package com.kos.character.clazz.db;

import com.kos.character.proficiencies.db.ProficiencyEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @Column(name = "class_id")
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false, name = "hit_dice")
    private Integer hitDice;

    @Column(nullable = false, name = "health_points")
    private Integer healthPoints;

    @Column(nullable = false, name = "health_points_on_higher_level")
    private Integer healthPointsOnHigherLevels;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "Class_Proficiency",
            joinColumns = { @JoinColumn(name = "class_id") },
            inverseJoinColumns = { @JoinColumn(name = "proficiency_id") }
    )
    private Set<ProficiencyEntity> proficiencies;

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

    public Integer getHitDice() {
        return hitDice;
    }

    public void setHitDice(Integer hitDice) {
        this.hitDice = hitDice;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getHealthPointsOnHigherLevels() {
        return healthPointsOnHigherLevels;
    }

    public void setHealthPointsOnHigherLevels(Integer healthPointsOnHigherLevels) {
        this.healthPointsOnHigherLevels = healthPointsOnHigherLevels;
    }

    public Set<ProficiencyEntity> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(Set<ProficiencyEntity> proficiencies) {
        this.proficiencies = proficiencies;
    }
}
