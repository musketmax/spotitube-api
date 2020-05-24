package com.thomas.spotitube.logic;

import com.thomas.spotitube.data.interfaces.IPlaylistDao;
import com.thomas.spotitube.domain.Playlist;
import com.thomas.spotitube.logic.interfaces.IPlaylistLogic;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import javax.inject.Inject;
import java.util.ArrayList;

public class PlayListLogic implements IPlaylistLogic {
    @Inject
    private IPlaylistDao playlistDao;

    /**
     * Get all playlists belonging to user
     *
     * @param userId: ObjectId
     * @return JSONObject
     */
    @Override
    public JSONObject getPlaylistsForUser(ObjectId userId) {
        ArrayList<Playlist> playlists = this.playlistDao.getPlaylists(userId);

        JSONObject result = new JSONObject();
        result.put("playlists", playlists);
        result.put("length", 0);

        return result;
    }
}
