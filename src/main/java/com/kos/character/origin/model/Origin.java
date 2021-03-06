package com.kos.character.origin.model;

public class Origin {

    private OriginId originId;
    private String name;

    public Origin(OriginId originId, String name) {
        this.originId = originId;
        this.name = name;
    }

    public OriginId getOriginId() {
        return originId;
    }

    public void setOriginId(OriginId originId) {
        this.originId = originId;
    }

    public String getName() {
        return name;
    }

}
