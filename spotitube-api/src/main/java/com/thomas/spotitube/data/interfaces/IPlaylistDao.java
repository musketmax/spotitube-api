package com.thomas.spotitube.data.interfaces;

import com.thomas.spotitube.domain.Playlist;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IPlaylistDao {
    ArrayList<Playlist> getPlaylists(ObjectId userId);
}
