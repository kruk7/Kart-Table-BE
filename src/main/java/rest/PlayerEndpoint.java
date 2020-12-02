package rest;

import dao.PlayerDao;
import model.Player;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/player")
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
            return Response.ok(player).build();
        } catch (NoResultException exception) {
            exception.printStackTrace();
            return Response.noContent().build();
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
            return Response.ok(allPlayer).build();
    }

    @POST
    public Response createPlayer(Player player) {
        if (player != null){
            playerDao.createPlayer(player);
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        }
        else
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
    }
}
