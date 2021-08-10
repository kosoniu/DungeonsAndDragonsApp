package com.kos.character.origin.db;

import com.kos.character.proficiencies.db.ProficiencyEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "origin")
public class OriginEntity {

    @Id
    @Column(name = "origin_id")
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "Origin_Proficiency",
            joinColumns = { @JoinColumn(name = "origin_id") },
            inverseJoinColumns = { @JoinColumn(name = "proficiency_id") }
    )
    private Set<ProficiencyEntity> proficiencies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<ProficiencyEntity> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(Set<ProficiencyEntity> proficiencies) {
        this.proficiencies = proficiencies;
    }
}
