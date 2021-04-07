package com.kos.character.race.db;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "race")
public class RaceEntity {

    @Id
    @GeneratedValue
    @NotNull
    private int id;

    @Column
    @NotNull
    private String name;

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
}
