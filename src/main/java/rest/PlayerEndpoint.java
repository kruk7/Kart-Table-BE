package rest;

import dao.PlayerDao;
import exception.DataNotFoundException;
import model.Player;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/players")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerEndpoint {

    @Inject
    PlayerDao playerDao;

    @GET
    @Path("/{id}")
    public Response getSinglePlayer(@PathParam("id") Long id) {
        try {
            Player player = playerDao.getSinglePlayer(id);
            return Response
                    .ok(player)
                    .build();
        } catch (NoResultException e) {
            e.printStackTrace();
            return Response
                    .noContent()
                    .build();
        }
    }

    @GET
    public Response getAllPlayers() {
        List<Player> allPlayer = playerDao.getAllPlayers();
        if (allPlayer.isEmpty())
            return Response
                    .noContent()
                    .build();
        else
            return Response
                    .ok(allPlayer)
                    .build();
    }

    @POST
    public Response createPlayer(Player player, @Context UriInfo uriInfo) {

        if (player == null) {
            throw new DataNotFoundException("Received null Player reference");
        }

        else if (player.getId() == null) {
            playerDao.createPlayer(player);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(player
                                    .getId()
                                    .toString())
                            .build())
                    .build();
        } else
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
    }
}
