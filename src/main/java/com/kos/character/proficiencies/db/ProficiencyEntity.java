package com.kos.character.proficiencies.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kos.character.origin.db.OriginEntity;
import com.kos.character.proficiencies.model.ProficiencyType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proficiency")
public class ProficiencyEntity {

    @Id
    @Column(name = "proficiency_id")
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ProficiencyType type;

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

    public ProficiencyType getType() {
        return type;
    }

    public void setType(ProficiencyType type) {
        this.type = type;
    }
}
