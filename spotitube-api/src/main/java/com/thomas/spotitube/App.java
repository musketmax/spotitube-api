package com.thomas.spotitube;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.thomas.spotitube.data.UserDao;
import com.thomas.spotitube.domain.Playlist;
import com.thomas.spotitube.domain.User;

import java.util.ArrayList;

public class App {
    // This method acts as a database seeder.
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Insert User document
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlist = new Playlist()
                .setName("Rock & Roll")
                .setOwner(true);
        playlists.add(playlist);

        User user = new User()
                .setUser("admin")
                .setPassword("1000:be8528029730569a3c0602cc6922bd7c:8953047bf438ad3840f4c6ce6de39fadaf0193245150b949a6f747da39cfed2396ecb4169088afd91ecf4c816f8657518eadde174de2b798f62fc887da7aadf8")
                .setPlaylists(playlists);

        MongoDatabase database = userDao.getDatabase();
        MongoCollection<User> collection = database.getCollection("users", User.class);
        collection.insertOne(user);
    }
}
