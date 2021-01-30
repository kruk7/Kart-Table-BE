package rest;

import dao.TrackDao;
import model.Track;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/tracks")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrackEndpoint {

    @Inject
    TrackDao trackDao;

    @GET
    @Path("/{id}")
    public Response getSingleTrack(@PathParam("id") Long id) {
        try {
            Track singleTrack = trackDao.getSingleTrack(id);
            return Response
                    .ok(singleTrack)
                    .build();
        } catch (NoResultException e) {
            e.printStackTrace();
            return Response
                    .noContent()
                    .build();
        }
    }

    @GET
    public Response getAllTracks() {
        List<Track> allTracks = trackDao.getAllTracks();
        if (allTracks.isEmpty()) {
            return Response
                    .noContent()
                    .build();
        } else
            return Response
                    .ok(allTracks)
                    .build();
    }

    @POST
    public Response createTrack(Track track, @Context UriInfo uriInfo) {
        if (track != null && track.getId() == null ) {
            trackDao.createTrack(track);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(track
                                    .getId()
                                    .toString())
                            .build())
                    .build();
        } else
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") Long id) {
        trackDao.deleteTrack(id);
        return Response
                .ok()
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTrack(Track track, @PathParam("id") Long id) {
        if (track != null) {
            trackDao.updateTrack(track, id);
            return Response
                    .ok()
                    .build();
        } else
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("An empty Track object reference was sent")
                    .build();
    }
}
