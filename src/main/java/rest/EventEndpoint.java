package rest;

import dao.EventDao;
import model.Event;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/event")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventEndpoint {

    @Inject
    EventDao eventDao;

    @GET
    @Path("/{id}")
    public Response getSingleEvent(@PathParam("id") Long id) {
        try {
            Event event = eventDao.getSingleEvent(id);
            return Response.ok(event).build();
        } catch (NoResultException e) {
            e.printStackTrace();
            return Response.noContent().build();
        }
    }

    @GET
    public Response getAllEvents() {
        List<Event> events = eventDao.getAllEvents();
        if (events.isEmpty())
            return Response
                    .noContent()
                    .build();
        else
            return Response
                    .ok(events)
                    .build();
    }

    @POST
    public Response createEvent(Event event, @Context UriInfo uriInfo) {
        if (event != null && event.getId() == null) {
            eventDao.createEvent(event);
            return Response
                    .created(uriInfo
                        .getAbsolutePathBuilder()
                        .path(event
                                .getId()
                                .toString())
                        .build())
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }
}
