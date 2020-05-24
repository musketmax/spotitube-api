package com.thomas.spotitube.services.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IPlaylistService {
    @GET
    Response get(@QueryParam("token") String token);
}
