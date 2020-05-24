package com.thomas.spotitube.data;

import com.mongodb.client.MongoCollection;
import com.thomas.spotitube.data.interfaces.IPlaylistDao;
import com.thomas.spotitube.domain.Playlist;
import com.thomas.spotitube.domain.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class PlaylistDao extends Database implements IPlaylistDao {

    /**
     * Get all playlists for user
     *
     * @param userId: ObjectId
     * @return ArrayList<Playlist>
     */
    @Override
    public ArrayList<Playlist> getPlaylists(ObjectId userId) {
        MongoCollection<User> collection = database.getCollection("users", User.class);
        User user = collection.find(eq("id", userId)).first();

        ArrayList<Playlist> playlists = new ArrayList<>();

        if (user != null) {
            playlists = user.getPlaylists();
        }

        return playlists;
    }
}
