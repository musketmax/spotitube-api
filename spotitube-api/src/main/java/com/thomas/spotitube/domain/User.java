package com.thomas.spotitube.domain;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class User {
    private ObjectId id;
    private String user;
    private String token;
    private String password;
    private ArrayList<Playlist> playlists;

    public ObjectId getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public User setUser(String user) {
        this.user = user;
        return this;
    }

    public String getToken() {
        return token;
    }

    public User setToken(String token) {
        this.token = token;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public User setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
        return this;
    }
}
