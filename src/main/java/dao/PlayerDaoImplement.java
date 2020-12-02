package dao;

import model.Event;
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
        Player player = em.find(Player.class, id);
        em.remove(player);
    }

    @Override
    //@Transactional
    public Player getSinglePlayer(Long id) {
        Player player = em.find(Player.class, id);
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        //TypedQuery<Player> query = em.createQuery("SELECT p.id, p.firstName from Player p", Player.class);

        TypedQuery<Player> query = em.createNamedQuery("Player.findAll", Player.class);
        return query.getResultList();
    }

    @Override
    public List<Player> getPlayersInEvent(Event event) {
        TypedQuery <Player> query = em.createNamedQuery("Player.findInEnent", Player.class);
        query.setParameter("event", event);
        List<Player> allPlayers = query.getResultList();
        return allPlayers;
    }
}
