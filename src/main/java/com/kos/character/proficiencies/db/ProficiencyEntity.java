package com.kos.character.proficiencies.db;

import com.kos.character.proficiencies.model.ProficiencyType;
import javax.persistence.*;

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
