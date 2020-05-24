package com.thomas.spotitube.domain;

import org.bson.types.ObjectId;

public class Playlist {
    private ObjectId id;
    private String name;
    private boolean owner;

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isOwner() {
        return owner;
    }

    public Playlist setOwner(boolean owner) {
        this.owner = owner;
        return this;
    }
}
