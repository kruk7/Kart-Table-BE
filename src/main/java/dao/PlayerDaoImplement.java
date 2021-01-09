package dao;

import model.Event;
import model.Lap;
import model.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PlayerDaoImplement implements PlayerDao {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void createPlayer(Player player) {
        player = Player.generateAlias(player);
        em.persist(player);
    }

    @Override
    @Transactional
    public void deletePlayer(Long id) {
        em.remove(getSinglePlayer(id));
    }

    @Override
    public void addLapToPlayer(Lap lap, Long playerId) {
        try {
            if ( lap != null && lap.getTrack() != null && lap.getPlayer() == null ) {
                Player player = em.getReference(Player.class, playerId);
                lap.setPlayer(player);
                em.persist(lap);
            }
            else throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player getSinglePlayer(Long id) {
        Player player = em.find(Player.class, id);
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        TypedQuery<Player> query = em.createNamedQuery("Player.findAll", Player.class);
        return query.getResultList();
    }

    @Override
    public List<Player> getPlayersInEvent(Event event) {
        TypedQuery<Player> query = em.createNamedQuery("Player.findInEvent", Player.class);
        query.setParameter("event", event);
        List<Player> allPlayers = query.getResultList();
        return allPlayers;
    }
}
