package com.kos.character.origin.db;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "origin")
public class OriginEntity {

    @Id
    @GeneratedValue
    @NotNull
    private Integer id;

    @Column
    @NotNull
    private String name;

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
}
