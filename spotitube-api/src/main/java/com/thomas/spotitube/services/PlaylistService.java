package com.thomas.spotitube.services;

import com.thomas.spotitube.data.constants.HttpMessageConstants;
import com.thomas.spotitube.domain.User;
import com.thomas.spotitube.exceptions.TokenInvalidException;
import com.thomas.spotitube.logic.interfaces.IPlaylistLogic;
import com.thomas.spotitube.logic.interfaces.IUserLogic;
import com.thomas.spotitube.services.interfaces.IPlaylistService;
import org.json.simple.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class PlaylistService implements IPlaylistService {
    @Inject
    private IUserLogic userLogic;

    @Inject
    private IPlaylistLogic playlistLogic;

    @Override
    public Response get(String token) {
        try {
            userLogic.validateToken(token);
            User user = userLogic.getUser(token);

            JSONObject playlists = playlistLogic.getPlaylistsForUser(user.getId());

            return Response
                    .status(Response.Status.OK)
                    .entity(playlists)
                    .build();
        } catch (TokenInvalidException e) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(HttpMessageConstants.NOT_AUTHORIZED)
                    .build();
        }
    }
}
