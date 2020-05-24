package com.thomas.spotitube.logic.interfaces;

import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

public interface IPlaylistLogic {
    JSONObject getPlaylistsForUser(ObjectId userId);
}
