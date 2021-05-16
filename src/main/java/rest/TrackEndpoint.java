package rest;

import dao.TrackDao;
import exception.DataNotFoundException;
import exception.EntityDuplicateValueException;
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
@Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
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

        if (track == null){
            throw new DataNotFoundException("Received null Track reference");
        }
        else if (track.getId() != null){
            throw new BadRequestException("id param has assigning value");
        }
        else if (trackDao.ifExist(track.getName())){
            throw new EntityDuplicateValueException("The Track with that name already exists");
        }

        else {
            trackDao.createTrack(track);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(track
                                    .getId()
                                    .toString())
                            .build())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") Long id) {

        Track track = trackDao.getSingleTrack(id);

        if (track == null)
            throw new DataNotFoundException("The Track with the identifier: " + id + " does not exist");

        else {
            trackDao.deleteTrack(id);
            return Response
                    .ok("The Track with the identifier: " + id + " has been deleted")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateTrack(Track track, @PathParam("id") Long id) {

        if (track == null)
            throw new BadRequestException("Received null Track reference");

        else if (trackDao.ifExist(track.getName()))
            throw new EntityDuplicateValueException("An Track with that name already exists");

        else {
            trackDao.updateTrack(track, id);
            return Response
                    .ok("The Track with the identifier: " + id + " has been updated")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }
}
